package com.anma.calculator.ui.core.component

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anma.calculator.R

@Composable
fun NavigationIcon(iconText: String, image: Painter, isActive: Boolean, onSelection: () -> Unit) {

    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(
                color = if (isActive){
                    MaterialTheme.colorScheme.primary
                }else{
                    Color.Transparent
                }, shape = RoundedCornerShape(100.dp)
            )
            .padding(12.dp, 12.dp)
    ) {

        Image(
            painter = image,
            contentDescription = "Nav Icon",
            modifier = Modifier
                .size(20.dp)
                .clickable(
                    enabled = true,
                    onClick = {
                        onSelection()
                    }
                ),
            colorFilter = ColorFilter.tint(color = if (isActive) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onSecondary)
        )

    }

}
