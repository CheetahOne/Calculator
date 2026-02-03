package com.anma.calculator.ui.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.anma.calculator.R
import com.anma.calculator.Utils.UiState
import com.anma.calculator.data.AppResources
import com.anma.calculator.data.CalculatorViewModel

@Composable
fun BottomNavigationBar(vm: CalculatorViewModel = hiltViewModel()) {

    val activeSection = vm.selectedSection.collectAsState()
    val appResources = remember { AppResources() }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
            )
            .padding(top = 1.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        appResources.navigationOptions.forEach { item ->
            NavigationIcon(
                iconText = appResources.getTabName(LocalContext.current, item),
                image = painterResource(appResources.getTabIcon(item)),
                isActive = activeSection.value == item,
                onSelection = {
                    vm.updateSelection(item)
                }
            )
        }
    }
}