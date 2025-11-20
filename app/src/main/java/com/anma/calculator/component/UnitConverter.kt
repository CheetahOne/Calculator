package com.anma.calculator.component

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun UnitConverter() {

    var firstValue = remember { mutableStateOf(0) }
    var secondValue = remember { mutableStateOf(0) }
    var inputValue = remember { mutableStateOf(0) }



}