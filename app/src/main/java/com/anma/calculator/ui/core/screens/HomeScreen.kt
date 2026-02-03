package com.anma.calculator.ui.core.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.anma.calculator.Utils.UiState
import com.anma.calculator.data.CalculatorViewModel
import com.anma.calculator.ui.core.component.BottomNavigationBar
import com.anma.calculator.ui.core.component.Calculator
import com.anma.calculator.ui.core.component.CurrencyConverter
import com.anma.calculator.ui.core.component.UnitConverter

@Composable
fun HomeScreen(navController: NavController, vm: CalculatorViewModel = hiltViewModel()) {

    val currentUiState = vm.selectedSection.collectAsState()


    Scaffold(

        bottomBar = {
            BottomNavigationBar()
        }

    ) { innerPadding ->
        Column(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background).padding(innerPadding),
        ) {
            when(currentUiState.value){

                UiState.CALCULATOR -> {
                    Calculator(navController)
                }

                UiState.UNITS -> {
                    UnitConverter(navController)
                }

                UiState.FINANCE -> {
                    CurrencyConverter(navController)
                }

                UiState.MATHS -> {
                    CurrencyConverter(navController)
                }

            }
        }
    }


}