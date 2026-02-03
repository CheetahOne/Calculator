package com.anma.calculator.ui.core.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.anma.calculator.R
import com.anma.calculator.Utils.Constants
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate(Constants.HOME_SCREEN){
            popUpTo(Constants.SPLASH){ inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Image(painterResource(R.drawable.logo), contentDescription = "logo", Modifier.size(150.dp))
    }

}