package com.anma.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.anma.calculator.navigation.AppNavGraph
import com.anma.calculator.screens.SplashScreen
import com.anma.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                val navController = rememberNavController()
                AppNavGraph(navController)
            }
        }
    }
}

