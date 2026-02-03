package com.anma.calculator.ui.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.anma.calculator.Utils.Constants
import com.anma.calculator.data.AppResources

@Composable
fun UnitConverter(navController: NavController) {

    val appResources = remember { AppResources() }

    Column(
        modifier = Modifier
            .padding(10.dp, 10.dp, 10.dp, 1.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement =  Arrangement.spacedBy(12.dp)
        ) { items(appResources.unitOptions){ iconName ->
            UnitConverterButton(
                icon = painterResource(
                    id = appResources.getResourcesForUnit(iconName)
                ),
                iconName = iconName, { it->
                   navController.navigate(Constants.UNIT_CONVERSION_SCREEN + "/$it")
                }, modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f))
        }

        }


    }



}