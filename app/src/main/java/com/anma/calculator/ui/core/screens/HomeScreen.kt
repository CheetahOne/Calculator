package com.anma.calculator.ui.core.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.anma.calculator.ui.core.component.BottomNavigationBar
import com.anma.calculator.ui.core.component.Calculator
import com.anma.calculator.ui.core.component.CurrencyConverter
import com.anma.calculator.ui.core.component.UnitConverter

enum class UiState {
    CALCULATOR, UNIT_CONVERTER, CURRENCY_CONVERTER
}

@Composable
fun HomeScreen(navController: NavController) {

    val currentUiState = remember { mutableStateOf(UiState.CALCULATOR) }

    Scaffold(

        bottomBar = {
            BottomNavigationBar(currentUiState, { selection ->
                currentUiState.value = selection
            })
        }

    ) { innerPadding ->
        Column(
            modifier = Modifier.background(brush = Brush.linearGradient(colors = listOf(MaterialTheme.colorScheme.tertiary,
                MaterialTheme.colorScheme.onSecondary))).padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            when(currentUiState.value){

                UiState.CALCULATOR -> {
                    Calculator()
                }

                UiState.UNIT_CONVERTER -> {
                    UnitConverter()
                }

                UiState.CURRENCY_CONVERTER -> {
                    CurrencyConverter()
                }

            }
        }
    }


}