package com.anma.calculator.ui.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Orange,
    secondary = LightBlack,
    tertiary = White,
    background = Black,
    onPrimary = GREEN,
    onSecondary = RED,
    onTertiary = LIGHTRED,
    surface = LIGHTGREEN
)

private val LightColorScheme = lightColorScheme(
    primary = Orange,
    secondary = LightBlack,
    tertiary = White,
    background = White,
    onPrimary = GREEN,
    onSecondary = RED,
    onTertiary = LIGHTRED
)

@Composable
fun CalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when(darkTheme){
        true -> DarkColorScheme
        false -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}