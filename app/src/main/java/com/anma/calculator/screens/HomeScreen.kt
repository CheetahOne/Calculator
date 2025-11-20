package com.anma.calculator.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.anma.calculator.R
import com.anma.calculator.component.NavigationIcon

enum class UiState {
    CALCULATOR, UNIT_CONVERTER, CURRENCY_CONVERTER
}

@Composable
fun HomeScreen(navController: NavController) {

    val currentUiState = remember { mutableStateOf(UiState.CALCULATOR) }

    Scaffold(

        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.secondary,
                        shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
                    )
                    .padding(0.dp, 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                NavigationIcon(
                    iconText = "Calculator",
                    image = painterResource(R.drawable.cal_tab_icon),
                    isActive = currentUiState.value == UiState.CALCULATOR,
                    onSelection = {
                        currentUiState.value = UiState.CALCULATOR
                    }
                )
                NavigationIcon(
                    iconText = "Unit Converter",
                    image = painterResource(R.drawable.scale_tab_icon),
                    isActive = currentUiState.value == UiState.UNIT_CONVERTER,
                    onSelection = {
                        currentUiState.value = UiState.UNIT_CONVERTER
                    })
                NavigationIcon(
                    iconText = "Currency Converter",
                    image = painterResource(R.drawable.currency_tab_icon),
                    isActive = currentUiState.value == UiState.CURRENCY_CONVERTER,
                    onSelection = {
                        currentUiState.value = UiState.CURRENCY_CONVERTER
                    })
            }
        }

    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button times.
                """.trimIndent(),
            )


        }
    }


}