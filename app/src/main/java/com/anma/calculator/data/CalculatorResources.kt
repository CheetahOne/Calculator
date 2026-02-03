package com.anma.calculator.data

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.anma.calculator.R
import com.anma.calculator.Utils.Constants
import kotlin.text.get

open class CalculatorResources {

    private val mappedResources = mapOf(
        Constants.AC to R.drawable.ac,
        Constants.BRACKET to R.drawable.bracket,
        Constants.PERCENTAGE to R.drawable.percent,
        Constants.DIVIDE to R.drawable.devide,
        Constants.SEVEN to R.drawable.seven,
        Constants.EIGHT to R.drawable.eight,
        Constants.NINE to R.drawable.nine,
        Constants.MULTIPLY to R.drawable.multiply,
        Constants.FOUR to R.drawable.four,
        Constants.FIVE to R.drawable.five,
        Constants.SIX to R.drawable.six,
        Constants.SUBTRACT to R.drawable.sub,
        Constants.ONE to R.drawable.one,
        Constants.TWO to R.drawable.two,
        Constants.THREE to R.drawable.three,
        Constants.ADD to R.drawable.add,
        Constants.ZERO to R.drawable.zero,
        Constants.DOT to R.drawable.dot,
        Constants.CLEAR to R.drawable.clear,
        Constants.EQUAL to R.drawable.equal
    )

    val mappedDigit = mapOf(
        Constants.ZERO to 0,
        Constants.ONE to 1,
        Constants.TWO to 2,
        Constants.THREE to 3,
        Constants.FOUR to 4,
        Constants.FIVE to 5,
        Constants.SIX to 6,
        Constants.SEVEN to 7,
        Constants.EIGHT to 8,
        Constants.NINE to 9,
    )

    public fun getResource(name: String): Int {
        return mappedResources[name] ?: 0
    }

    public fun getDigit(name: String): Int{
        return mappedDigit[name] ?: 0
    }

    @Composable
    public fun getButtonColor(name: String): Color {
        return when (name) {
            Constants.DIVIDE, Constants.MULTIPLY, Constants.SUBTRACT, Constants.ADD -> {
                MaterialTheme.colorScheme.primary
            }

            Constants.EQUAL -> {
                MaterialTheme.colorScheme.onPrimary
            }

            Constants.AC -> {
                MaterialTheme.colorScheme.onTertiary
            }

            else -> {
                MaterialTheme.colorScheme.secondary
            }
        }
    }

}