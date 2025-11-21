package com.anma.calculator.ui.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.anma.calculator.R
import com.anma.calculator.Utils.Constants

@Composable
fun Calculator() {

    val buttons = listOf(
        listOf(Constants.AC, Constants.BRACKET, Constants.PERCENTAGE, Constants.DIVIDE),
        listOf(Constants.SEVEN, Constants.EIGHT, Constants.NINE, Constants.MULTIPLY),
        listOf(Constants.FOUR, Constants.FIVE, Constants.SIX, Constants.SUBTRACT),
        listOf(Constants.ONE, Constants.TWO, Constants.THREE, Constants.ADD),
        listOf(Constants.ZERO, Constants.DOT, Constants.CLEAR, Constants.EQUAL)
    )

    Column(modifier = Modifier.fillMaxSize()) {

        val calculationValue = remember { mutableStateOf("") }

        DisplaySection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .background(color = MaterialTheme.colorScheme.primary, RoundedCornerShape(20.dp))
                .padding(5.dp)
                .weight(1f),
            calculationValue = calculationValue.value
        )

        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 24.dp, vertical = 15.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            buttons.forEach { row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    row.forEach { iconName ->
                        CalculatorButton(
                            icon = painterResource(
                                id = getResource(iconName)
                            ),
                            backgroundColor = getButtonColor(iconName),
                            iconName,
                            { it ->
                                calculationValue.value += it
                            }
                        )
                    }
                }
            }

        }

    }

}

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

fun getResource(name: String): Int {
    return mappedResources[name] ?: 0
}

@Composable
fun getButtonColor(name: String): Color {
    return if (name in listOf(Constants.DIVIDE, Constants.MULTIPLY, Constants.SUBTRACT, Constants.ADD, Constants.EQUAL))
        MaterialTheme.colorScheme.primary
    else
        MaterialTheme.colorScheme.onSecondary
}