package com.anma.calculator.domain

import android.util.Log
import com.anma.calculator.Utils.Constants
import com.anma.calculator.Utils.Utility
import com.anma.calculator.data.CalculatorResources
import javax.inject.Inject
import kotlin.math.pow

open class CalculatorUseCase @Inject constructor() {

    val calculatorResources = CalculatorResources()
    val numbers = mutableListOf<Double>()
    val operators = mutableListOf<String>()
    var isDecimalActive = false
    private var decimalPosition = 0
    private var utility = Utility()

    fun handleEntry(
        name: String,
        latestResult: String,
        clear: () -> Unit,
        dropLast: () -> Unit,
        updateDisplay: (String) -> Unit,
        updateData: (MutableList<Double>, MutableList<String>) -> Unit
    ) {

        when (name) {
            Constants.AC -> {
                numbers.clear()
                operators.clear()
                isDecimalActive = false
                decimalPosition = 0
                clear()
            }

            Constants.CLEAR -> {
                dropLast()
                if (numbers.isEmpty()) return
                if (operators.size == numbers.size) {
                    operators.removeAt(operators.size - 1)
                } else {
                    val lastNumber = utility.formatNumber(numbers[numbers.size - 1])
                    if (lastNumber.length == 1) {
                        numbers.removeAt(numbers.size - 1)
                    } else {
                        if (lastNumber.contains(Constants.DOT)){
                            Log.d("Calculator", "handleEntry: This is a decimal number $lastNumber")
                            isDecimalActive = true
                            val newValue = lastNumber.dropLast(1)
                            numbers[numbers.size-1] = newValue.toDouble()
                            decimalPosition = newValue.substringAfter("." ,"").length
                            Log.d("Calculator", "handleEntry: Decimal Position value is : $decimalPosition")
                            if (decimalPosition == 0){
                                Log.d("Calculator", "handleEntry: Decimal number finish")
                            }
                        }else{
                            Log.d("Calculator", "handleEntry: This is not a decimal number")
                            if (isDecimalActive && decimalPosition == 0){
                                Log.d("Calculator", "handleEntry: This is not a decimal number but decimal is active")

                                isDecimalActive = false
                                return
                            }else{
                                numbers[numbers.size-1] = lastNumber.dropLast(1).toDouble()
                            }

                        }
                    }
                }
                Log.d("Calculator", "handleEntry: ${numbers[numbers.size-1]}")
            }

            Constants.ZERO, Constants.ONE, Constants.TWO, Constants.THREE, Constants.FOUR,
            Constants.FIVE, Constants.SIX, Constants.SEVEN, Constants.EIGHT, Constants.NINE -> {

                val digit = calculatorResources.getDigit(name)
                Log.d("Calculator", "handleEntry: Input number $digit")


                if (numbers.isEmpty()) {
                    numbers.add(digit.toDouble())
                    updateDisplay(name)
                    return
                }

                if (operators.size < numbers.size) {
                    val updated = if (isDecimalActive)
                        getValueWithDecimal(numbers.last(), digit)
                    else
                        appendValue(numbers.last(), digit)

                    numbers[numbers.size - 1] = updated
                    updateData(numbers, operators)
                    updateDisplay(name)
                    return
                }

                numbers.add(digit.toDouble())
                updateDisplay(name)
            }

            Constants.DOT -> {
                if (!isDecimalActive) {
                    isDecimalActive = true
                    decimalPosition = 0

                    if (numbers.isEmpty()) {
                        numbers.add(0.0)
                    }

                    updateDisplay(name)
                }
            }

            Constants.ADD, Constants.SUBTRACT, Constants.MULTIPLY, Constants.DIVIDE, Constants.PERCENTAGE -> {

                if (numbers.isEmpty()) {
                    if (name == Constants.SUBTRACT) {
                        numbers.add(-0.0)
                        updateDisplay(name)
                    }
                    return
                }

                isDecimalActive = false
                decimalPosition = 0

                if (operators.size == numbers.size) {
                    if (name == Constants.SUBTRACT && (operators.last() == Constants.PERCENTAGE || operators.last() == Constants.DIVIDE || operators.last() == Constants.MULTIPLY)) {
                        numbers.add(-0.0)
                        updateDisplay(name)
                    } else {
                        operators[operators.size - 1] = name
                        dropLast()
                        updateDisplay(name)
                        updateData(numbers, operators)
                    }
                    return
                }

                operators.add(name)
                updateDisplay(name)
            }

            Constants.EQUAL -> {
                numbers.clear()
                operators.clear()
                numbers.add(latestResult.toDouble())
            }

        }
        updateData(numbers, operators)
    }

    private fun appendValue(value: Double, new: Int): Double {
        return value * 10 + new
    }

    private fun dropValue(value: Double): Double {
        val s = value.toString()
        if (s.length <= 1) return 0.0

        val dropped = s.dropLast(1)

        return if (dropped == "" || dropped == "-") 0.0 else dropped.toDouble()
    }

    private fun getValueWithDecimal(value: Double, new: Int): Double {
        decimalPosition++

        val factor = 10.0.pow(decimalPosition)
        val newValue = value + new / factor
        Log.d("Calculator", "getValueWithDecimal: $newValue")
        return newValue
    }

}