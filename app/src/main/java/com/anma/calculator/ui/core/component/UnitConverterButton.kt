package com.anma.calculator.ui.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anma.calculator.Utils.Constants
import com.anma.calculator.data.AppResources

@Composable
fun UnitConverterButton(
    icon: Painter,
    iconName: String,
    onClick: (String) -> Unit,
    modifier: Modifier
) {

    val appResources = remember { AppResources() }

    Box(
        modifier = modifier
            .wrapContentHeight()
            .clickable { onClick(iconName) }
            .shadow(16.dp, RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .padding(15.dp),
        contentAlignment = Alignment.Center
    ) {

        Column(verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(appResources.getResourcesForUnit(iconName)),
                contentDescription = "Button Image",
                modifier = Modifier
                    .size(40.dp),
            )

            Text(
                text = appResources.getUnitName(LocalContext.current, iconName),
                textAlign = TextAlign.Center,
                fontSize = 11.sp,
                fontWeight = FontWeight(400),
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)
            )
        }

    }

}