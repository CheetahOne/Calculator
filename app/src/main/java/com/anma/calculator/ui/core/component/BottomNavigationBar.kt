package com.anma.calculator.ui.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.anma.calculator.R
import com.anma.calculator.ui.core.screens.UiState

@Composable
fun BottomNavigationBar(currentSelection: MutableState<UiState>, onSelection: (UiState) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.onSecondary,
                        MaterialTheme.colorScheme.tertiary
                    ),
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(0f, 0f)                ),
                shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
            )
            .padding(0.dp, 10.dp, 0.dp, 25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        NavigationIcon(
            iconText = "Calculator",
            image = painterResource(R.drawable.cal_tab_icon),
            isActive = currentSelection.value == UiState.CALCULATOR,
            onSelection = {
                onSelection(UiState.CALCULATOR)
            }
        )
        NavigationIcon(
            iconText = "Unit Converter",
            image = painterResource(R.drawable.scale_tab_icon),
            isActive = currentSelection.value == UiState.UNIT_CONVERTER,
            onSelection = {
                onSelection(UiState.UNIT_CONVERTER)
            })
        NavigationIcon(
            iconText = "Currency Converter",
            image = painterResource(R.drawable.currency_tab_icon),
            isActive = currentSelection.value == UiState.CURRENCY_CONVERTER,
            onSelection = {
                onSelection(UiState.CURRENCY_CONVERTER)
            })
    }
}