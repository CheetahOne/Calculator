package com.anma.calculator.ui.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.anma.calculator.R
import com.anma.calculator.data.CalculatorViewModel

@Composable
fun DisplaySection(modifier: Modifier, vm: CalculatorViewModel = hiltViewModel()) {

    val inputValue = vm.displayValue.collectAsState()
    val result = vm.runningResult.collectAsState()

    val scrollState = rememberScrollState()

    val minFontSize = 60.sp
    val maxFontSize = 110.sp

    LaunchedEffect(inputValue.value) {
        scrollState.scrollTo(scrollState.maxValue)
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomEnd
    ) {
        Column {

            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp)
            ) {
                var dynamicFontSize by remember { mutableStateOf(maxFontSize) }
                val textMeasurer = rememberTextMeasurer()
                val density = LocalDensity.current

                LaunchedEffect(inputValue.value, maxWidth) {
                    var fontSize = maxFontSize
                    val maxWidthPx = with(density) { maxWidth.toPx() }

                    while (fontSize > minFontSize) {

                        val textLayout = textMeasurer.measure(
                            text = AnnotatedString(inputValue.value),
                            style = TextStyle(fontSize = fontSize)
                        )

                        if (textLayout.size.width <= maxWidthPx) break

                        fontSize = (fontSize.value - 2).sp
                    }

                    dynamicFontSize = fontSize
                }

                val scrollModifier =
                    if (dynamicFontSize <= minFontSize)
                        Modifier.fillMaxWidth().horizontalScroll(scrollState)
                    else Modifier.fillMaxWidth()

                Text(
                    text = inputValue.value,
                    fontSize = dynamicFontSize,
                    color = MaterialTheme.colorScheme.tertiary,
                    fontFamily = FontFamily(Font(R.font.digital_font)),
                    maxLines = 1,
                    textAlign = TextAlign.End,
                    modifier = scrollModifier
                )
            }

            Text(
                text = result.value,
                textAlign = TextAlign.End,
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = FontFamily(Font(R.font.digital_font)),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = 20.dp)
                    .background(color = Color.Transparent),
                maxLines = 1
            )
        }
    }
}

