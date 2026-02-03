package com.anma.calculator.domain

import android.util.Log
import com.anma.calculator.Utils.Constants
import java.math.RoundingMode
import javax.inject.Inject

class CalculatorEngine @Inject constructor() {

    fun evaluate(number: MutableList<Double>, operators: MutableList<String>): Double{

        if (number.isEmpty()) return 0.0

        if (operators.size >= number.size){
            operators.removeAt(operators.size-1)
        }

        handlePercentage(number, operators)

        solveMulDiv(number, operators)

        return solveAddSub(number, operators)

    }

    private fun solveAddSub(
        number: MutableList<Double>,
        operators: MutableList<String>
    ): Double {
        var result = number[0]
        Log.d("Calculator", "solveAddSub: $result")

        for (i in operators.indices){
            when(operators[i]){
                Constants.ADD -> {
                    Log.d("Calculator", "solveAddSub: ${number[i + 1]}")
                    result += number[i + 1]
                }
                Constants.SUBTRACT -> result -= number[i+1]
            }
        }
        Log.d("Calculator", "solveAddSub: $result")
        return result.toBigDecimal().setScale(10, RoundingMode.HALF_UP).stripTrailingZeros().toDouble()
    }

    private fun solveMulDiv(
        number: MutableList<Double>,
        operators: MutableList<String>
    ) {

        var i = 0
        while (i < operators.size){
            when(operators[i]){
                Constants.MULTIPLY -> {
                    number[i] *=  number[i+1]
                    number.removeAt(i+1)
                    operators.removeAt(i)
                }

                Constants.DIVIDE -> {
                    if (number[i+1] == 0.0){
                        throw ArithmeticException("Can not divide by 0")
                    }
                    number[i] /= number[i+1]
                    number.removeAt(i+1)
                    operators.removeAt(i)
                }
                else -> i++
            }
        }

    }

    fun handlePercentage(numbers: MutableList<Double>, operator: MutableList<String>){
        var index = operator.indexOf(Constants.PERCENTAGE)

        while (index != -1){
            val value = numbers[index]/100
            numbers[index] = value
            operator.removeAt(index)
            index = operator.indexOf(Constants.PERCENTAGE)
        }
    }



}