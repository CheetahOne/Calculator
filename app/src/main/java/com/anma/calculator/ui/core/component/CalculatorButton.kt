package com.anma.calculator.ui.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.anma.calculator.R
import com.anma.calculator.Utils.Constants

@Composable
fun CalculatorButton(icon: Painter, backgroundColor: Color, iconName: String, onClick: (String) -> Unit) {



    Box(
        modifier = Modifier
            .wrapContentSize()
            .clickable(
                enabled = true,
                onClick = {
                    onClick(iconName)
                }
            )
            .shadow(
                elevation = 16.dp,
                shape = CircleShape,
                clip = false
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(20.dp)
            )
            .clip(RoundedCornerShape(20.dp))
            .background(backgroundColor)
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = icon,
            contentDescription = "Button Image",
            modifier = Modifier
                .size(35.dp)
                .padding(top = if (iconName == Constants.DOT) 20.dp else 0.dp)
        )

    }

}