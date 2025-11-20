package com.anma.calculator.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculator() {

    Column(Modifier.fillMaxSize()) {


        Box(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(24.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(20.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(15.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(0.dp, 0.dp, 0.dp, 15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "AC",
                        color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        color = Color.White,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        color = Color.White,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        modifier = Modifier
                            .wrapContentSize()
                            .background(
                                color = MaterialTheme.colorScheme.tertiary,
                                shape = RoundedCornerShape(50.dp)
                            )
                            .padding(10.dp),
                        color = androidx.compose.ui.graphics.Color.White,
                        fontSize = 34.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(0.dp, 0.dp, 0.dp, 15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "AC",
                        color = Color.White,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        color = Color.White,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        color = Color.White,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        modifier = Modifier
                            .wrapContentSize()
                            .background(
                                color = MaterialTheme.colorScheme.tertiary,
                                shape = RoundedCornerShape(50.dp)
                            )
                            .padding(10.dp),
                        color = Color.White,
                        fontSize = 34.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(0.dp, 0.dp, 0.dp, 15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "AC",
                        color = Color.White,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        color = Color.White,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        color = Color.White,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        modifier = Modifier
                            .wrapContentSize()
                            .background(
                                color = MaterialTheme.colorScheme.tertiary,
                                shape = RoundedCornerShape(50.dp)
                            )
                            .padding(10.dp),
                        color = Color.White,
                        fontSize = 34.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(0.dp, 0.dp, 0.dp, 15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "AC",
                        color = Color.White,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        color = Color.White,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        color = Color.White,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        modifier = Modifier
                            .wrapContentSize()
                            .background(
                                color = MaterialTheme.colorScheme.tertiary,
                                shape = RoundedCornerShape(50.dp)
                            )
                            .padding(10.dp),
                        color = androidx.compose.ui.graphics.Color.White,
                        fontSize = 34.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(0.dp, 0.dp, 0.dp, 5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "AC",
                        color = Color.White,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        color = Color.White,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        color = Color.White,
                        fontSize = 34.sp
                    )
                    Text(
                        text = "AC",
                        modifier = Modifier
                            .wrapContentSize()
                            .background(
                                color = MaterialTheme.colorScheme.tertiary,
                                shape = RoundedCornerShape(50.dp)
                            )
                            .padding(10.dp),
                        color = androidx.compose.ui.graphics.Color.White,
                        fontSize = 34.sp
                    )
                }
            }

        }


    }

}