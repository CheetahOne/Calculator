package com.anma.calculator.ui.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NavigationIcon(iconText: String, image: Painter, isActive: Boolean, onSelection: () -> Unit) {

    Box(
        modifier = Modifier
            .wrapContentSize()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = image,
                contentDescription = "Nav Icon",
                modifier = Modifier
                    .size(35.dp)
                    .background(color = if (isActive){
                        MaterialTheme.colorScheme.background
                    }else{
                        Color.Transparent
                    }, RoundedCornerShape(100.dp))
                    .clickable(
                        enabled = true, onClick = {
                            onSelection()
                        })
                    .padding(8.dp),
                colorFilter = ColorFilter.tint(color = if (isActive) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.tertiary))

            if (isActive) {
                Text(
                    iconText,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
            }
        }

    }

}
