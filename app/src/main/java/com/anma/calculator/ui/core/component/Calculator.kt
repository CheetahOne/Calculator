package com.anma.calculator.ui.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.anma.calculator.Utils.Constants
import com.anma.calculator.data.CalculatorResources
import com.anma.calculator.data.CalculatorViewModel

@Composable
fun Calculator(navController: NavController,vm: CalculatorViewModel = hiltViewModel()) {

    val calculatorResources = remember { CalculatorResources() }

    val buttons = listOf(
        listOf(Constants.AC, Constants.BRACKET, Constants.PERCENTAGE, Constants.DIVIDE),
        listOf(Constants.SEVEN, Constants.EIGHT, Constants.NINE, Constants.MULTIPLY),
        listOf(Constants.FOUR, Constants.FIVE, Constants.SIX, Constants.SUBTRACT),
        listOf(Constants.ONE, Constants.TWO, Constants.THREE, Constants.ADD),
        listOf(Constants.ZERO, Constants.DOT, Constants.CLEAR, Constants.EQUAL)
    )

    Column(modifier = Modifier.fillMaxSize()) {

        val displayValue = remember { mutableStateOf("") }

        DisplaySection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .padding(5.dp)
                .weight(1f)
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
                                id = calculatorResources.getResource(iconName)
                            ),
                            backgroundColor = calculatorResources.getButtonColor(iconName),
                            iconName
                        ) { it ->
                            vm.onInput(it)
                            }
                    }
                }
            }
        }

    }

}
