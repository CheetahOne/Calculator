package com.anma.calculator.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anma.calculator.Utils.ActiveField
import com.anma.calculator.Utils.Constants
import com.anma.calculator.Utils.UiState
import com.anma.calculator.Utils.Utility
import com.anma.calculator.domain.CalculatorEngine
import com.anma.calculator.domain.CalculatorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CalculatorViewModel @Inject constructor(
    private val useCase: CalculatorUseCase,
    private val appEngine: CalculatorEngine,
    private val appResources: AppResources
): ViewModel(){


    private val _selectedUnit = MutableStateFlow("")
    val selectedUnit = _selectedUnit.asStateFlow()

    private val _topValue = MutableStateFlow("1")
    val topValue = _topValue.asStateFlow()

    private val _topUnit = MutableStateFlow("")
    val topUnit = _topUnit.asStateFlow()

    private val _bottomUnit = MutableStateFlow("")
    val bottomUnit = _bottomUnit.asStateFlow()

    private val _bottomValue = MutableStateFlow("")
    val bottomValue = _bottomValue.asStateFlow()

    private val _activeField = MutableStateFlow(ActiveField.TOP)
    val activeField = _activeField.asStateFlow()

    private val _selectedSection = MutableStateFlow(UiState.UNITS)
    val selectedSection = _selectedSection.asStateFlow()

    private val _runningResult = MutableStateFlow("")
    val runningResult = _runningResult.asStateFlow()

    private val _displayValue = MutableStateFlow("")
    val displayValue = _displayValue.asStateFlow()
    init {
        viewModelScope.launch {
            val flows = arrayOf(_topValue, _bottomValue, _topUnit, _bottomUnit, _selectedUnit, _activeField)
            combine<Any, Unit>(*flows){

            }.collect{
                calculate()
            }
        }
    }
    fun updateSelection(selection: UiState){
        _selectedSection.value = selection
    }

    fun updateActiveField(value: ActiveField){
        _activeField.value = value
    }

    fun updateTopValue(value: String){
        _topValue.value = value
    }
    fun updateTopUnit(unit: String){
        _topUnit.value = unit
    }
    fun updateBottomValue(value: String){
        _bottomValue.value = value
    }
    fun updateBottomUnit(unit: String){
        _bottomUnit.value = unit
    }

    fun updateSelectedUnit(value: String){
        _selectedUnit.value = value
    }

    private val utility = Utility()

    private val numbers = mutableListOf<Double>()
    private val operators = mutableListOf<String>()

    fun onInput(input: String){
        useCase.handleEntry(
            name = input,
            latestResult = runningResult.value,
            clear = {
                _displayValue.value = ""
                _runningResult.value = ""
                numbers.clear()
                operators.clear()
            },
            dropLast = {
                _displayValue.value = _displayValue.value.dropLast(1)
            },
            updateDisplay = {it ->
                _displayValue.value += it
            }, updateData = { updatedNumbers, updatedOperators ->
                numbers.clear()
                numbers.addAll(updatedNumbers)

                operators.clear()
                operators.addAll(updatedOperators)

                if (input == Constants.EQUAL){
                    _displayValue.value = runningResult.value
                    _runningResult.value = ""
                }


                if (numbers.isEmpty() || operators.isEmpty()){
                    _runningResult.value = ""
                }else{
                    val runningResult = appEngine.evaluate(numbers, operators)
                    _runningResult.value = utility.formatNumber(runningResult)
                }
            }
        )
    }

    fun calculate() {
        if (_topUnit.value.isEmpty() || _bottomUnit.value.isEmpty()) return

        var baseValue: String
        var baseUnit: String
        var targetUnit: String

        if (activeField.value == ActiveField.TOP){
            baseValue = topValue.value
            baseUnit = topUnit.value
            targetUnit = bottomUnit.value
        }else{
            baseValue = bottomValue.value
            baseUnit = bottomUnit.value
            targetUnit = topUnit.value
        }

        when(selectedUnit.value){
            Constants.FUEL -> convertFuel(baseValue.toDouble(), baseUnit, targetUnit)
            Constants.TEMPERATURE -> convertTemperature(baseValue.toDouble(), baseUnit, targetUnit)
            else -> {
                val num = baseValue.toDoubleOrNull() ?: 0.0
                val res = (num * appResources.getFactor(baseUnit)) / appResources.getFactor(targetUnit)
                if (activeField.value == ActiveField.TOP){
                    _bottomValue.value = "%.4f".format(res).trimEnd('0').trimEnd('.')
                }else{
                    _topValue.value = "%.4f".format(res).trimEnd('0').trimEnd('.')
                }
            }
        }




    }

    fun convertFuel(value: Double, fromUnit: String, toUnit: String){
        val kmPerLiter = when (fromUnit) {
            "L/100km" -> 100.0 / value
            "mpg US" -> value * 0.425144
            "mpg UK" -> value * 0.354006
            else -> value // assume km/L
        }

        val value = when (toUnit) {
            "L/100km" -> 100.0 / kmPerLiter
            "mpg US" -> kmPerLiter / 0.425144
            "mpg UK" -> kmPerLiter / 0.354006
            else -> kmPerLiter
        }

        if (activeField.value == ActiveField.TOP){
            _bottomValue.value = "%.4f".format(value).trimEnd('0').trimEnd('.')
        }else{
            _topValue.value = "%.4f".format(value).trimEnd('0').trimEnd('.')
        }
    }

    fun convertTemperature(value: Double, fromUnit: String, toUnit: String){
        val celsius = when (fromUnit) {
            "Celsius" -> value
            "Fahrenheit" -> (value - 32) * 5 / 9
            "Kelvin" -> value - 273.15
            else -> value
        }

        val value = when (toUnit) {
            "Celsius" -> celsius
            "Fahrenheit" -> (celsius * 9 / 5) + 32
            "Kelvin" -> celsius + 273.15
            else -> celsius
        }

        if (activeField.value == ActiveField.TOP){
            _bottomValue.value = "%.4f".format(value).trimEnd('0').trimEnd('.')
        }else{
            _topValue.value = "%.4f".format(value).trimEnd('0').trimEnd('.')
        }
    }


}