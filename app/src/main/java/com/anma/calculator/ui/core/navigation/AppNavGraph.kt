package com.anma.calculator.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anma.calculator.Utils.Constants
import com.anma.calculator.ui.core.screens.HomeScreen
import com.anma.calculator.ui.core.screens.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Constants.SPLASH
    ){
        composable(Constants.SPLASH){
            SplashScreen(navController)
        }
        composable(Constants.HOME_SCREEN){
            HomeScreen(navController)
        }

    }

}