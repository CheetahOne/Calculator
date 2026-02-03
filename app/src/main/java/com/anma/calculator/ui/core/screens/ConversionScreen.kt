package com.anma.calculator.ui.core.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.anma.calculator.R
import com.anma.calculator.Utils.ActiveField
import com.anma.calculator.data.AppResources
import com.anma.calculator.data.CalculatorViewModel
import com.anma.calculator.ui.core.component.UnitConversionLayout
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback

@Composable
fun ConversionScreen(
    navController: NavController, headerName: String, vm: CalculatorViewModel = hiltViewModel()
) {
    val appResources = remember { AppResources() }
    val selectedCategory by vm.selectedUnit.collectAsState()
    val haptic = LocalHapticFeedback.current

    LaunchedEffect(Unit) {
        if (selectedCategory.isEmpty()){
            vm.updateSelectedUnit(headerName)
        }
    }

    val unitOptionsForSelection = remember(selectedCategory) {
        appResources.getUnitsData(selectedCategory)?.toMutableList()
    }
    val unitListForSelection =
        remember(unitOptionsForSelection) { unitOptionsForSelection?.map { it.name } }
    var sourceUnit by remember(unitListForSelection) { mutableStateOf(unitListForSelection?.get(0)) }
    var targetedUnit by remember(unitListForSelection) { mutableStateOf(unitListForSelection?.get(1)) }
    val sourceAbbreviation by remember(sourceUnit) { mutableStateOf(unitOptionsForSelection?.find { it.name == sourceUnit }?.symbol) }
    val targetedAbbreviation by remember(targetedUnit) { mutableStateOf(unitOptionsForSelection?.find { it.name == targetedUnit }?.symbol) }
    vm.updateTopUnit(sourceUnit.toString())
    vm.updateBottomUnit(targetedUnit.toString())

    val iconRes = remember(selectedCategory) {
        val resId = appResources.getResourcesForUnit(selectedCategory.lowercase())
        if (resId != 0) resId else R.drawable.area
    }

    val inlineContent = mapOf(
        "icon" to InlineTextContent(
            Placeholder(
                width = 24.sp,
                height = 24.sp,
                placeholderVerticalAlign = PlaceholderVerticalAlign.Center
            )
        ) {
            if (iconRes != 0) {
                Image(
                    painter = painterResource(id = iconRes),
                    contentDescription = null
                )
            }
        }
    )

    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .windowInsetsPadding(WindowInsets.statusBars),
        verticalArrangement = Arrangement.Top,
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(R.drawable.back),
                contentDescription = "Back",
                Modifier
                    .size(40.dp)
                    .clickable(
                        enabled = true, onClick = {
                            navController.popBackStack()
                        })
                    .padding(top = 10.dp, end = 10.dp, bottom = 10.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.tertiary)
            )
            Text(
                text = buildAnnotatedString {
                    appendInlineContent("icon", "[icon]")
                    append("  ${appResources.getUnitName(LocalContext.current, selectedCategory)}")
                },
                inlineContent = inlineContent,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(20.dp)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(appResources.unitOptions) { item ->
                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable(onClick = {
                            vm.updateSelectedUnit(item)
                            haptic.performHapticFeedback(HapticFeedbackType.Confirm)
                        })
                        .background(
                            color = if (selectedCategory == item) {
                                MaterialTheme.colorScheme.onPrimary
                            } else {
                                MaterialTheme.colorScheme.secondary
                            }, shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = appResources.getUnitName(LocalContext.current, item),
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(200),
                        color = if (selectedCategory == item) {
                            MaterialTheme.colorScheme.background
                        } else {
                            MaterialTheme.colorScheme.tertiary
                        }
                    )
                }
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 10.dp)
        ) {

            Column() {
                UnitConversionLayout(
                    vm.topValue.collectAsState().value,
                    unitListForSelection,
                    sourceUnit.toString(),
                    sourceAbbreviation.toString(),
                    { it->
                        sourceUnit = it
                    },
                    {
                        vm.updateTopValue(it)
                        vm.updateActiveField(ActiveField.TOP)
                    })

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                )

                UnitConversionLayout(
                    vm.bottomValue.collectAsState().value,
                    unitListForSelection,
                    targetedUnit.toString(),
                    targetedAbbreviation.toString(),
                    {it ->
                        targetedUnit = it
                    },
                    {
                        vm.updateBottomValue(it)
                        vm.updateActiveField(ActiveField.BOTTOM)
                    })
            }

            Image(
                painterResource(R.drawable.coversion_arrow),
                contentDescription = "conversion arrow",
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.Center)
            )

        }


    }


}