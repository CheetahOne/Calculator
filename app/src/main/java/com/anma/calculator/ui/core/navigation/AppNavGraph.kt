package com.anma.calculator.ui.core.navigation

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anma.calculator.Utils.Constants
import com.anma.calculator.ui.core.component.UnitConverter
import com.anma.calculator.ui.core.screens.ConversionScreen
import com.anma.calculator.ui.core.screens.HomeScreen
import com.anma.calculator.ui.core.screens.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    val startingPoint = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
        Constants.HOME_SCREEN
    }else{
        Constants.SPLASH
    }

    NavHost(
        navController = navController,
        startDestination = startingPoint
    ){
        composable(Constants.SPLASH){
            SplashScreen(navController)
        }
        composable(Constants.HOME_SCREEN){
            HomeScreen(navController)
        }
        composable(Constants.UNIT_CONVERSION_SCREEN + "/{header}") { it ->
            val header = it.arguments?.getString("header")
            ConversionScreen(navController, header.toString())
        }

    }

}