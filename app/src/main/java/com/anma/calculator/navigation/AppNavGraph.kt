package com.anma.calculator.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anma.calculator.screens.HomeScreen
import com.anma.calculator.screens.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ){
        composable(Routes.SPLASH){
            SplashScreen(navController)
        }
        composable(Routes.HOME_SCREEN){
            HomeScreen(navController)
        }

    }

}