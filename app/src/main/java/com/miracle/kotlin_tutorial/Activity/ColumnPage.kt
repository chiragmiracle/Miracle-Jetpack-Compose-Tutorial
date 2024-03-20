package com.miracle.kotlin_tutorial.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.kotlin_tutorial.R
import com.miracle.kotlin_tutorial.ui.theme.ColorAccent
import com.miracle.kotlin_tutorial.ui.theme.Kotlin_TutorialTheme
import com.miracle.kotlin_tutorial.ui.theme.White

class ColumnPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_TutorialTheme {
                ColumnPageUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ColumnPageUI() {
        Kotlin_TutorialTheme {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(ColorAccent)
                            .height(55.dp),

                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(White),
                            modifier = Modifier
                                .height(55.dp)
                                .width(55.dp)
                                .padding(15.dp)
                                .clickable {
                                    finish()
                                },
                        )
                        Text(
                            text = "Column Demo",
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(alignment = Alignment.Center)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(10.dp)
                    ) {
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Simple Column :",
                            color = Color.Black,
                            fontSize = 15.sp,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        SimpleColumn()
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Weight With Column :",
                            color = Color.Black,
                            fontSize = 15.sp,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        ColumnWithWeight()
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Arrangement With Column :",
                            color = Color.Black,
                            fontSize = 15.sp,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        ColumnArrangement()
                    }
                }
            }
        }
    }

    @Composable
    fun SimpleColumn() {
        Column {
            Text(text = "Text 1", color = Color.Blue)
            Text(text = "Text 2", color = Color.Red)
            Text(text = "Text 3", color = Color.Green)
        }
    }

    @Composable
    fun ColumnWithWeight() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
        ) {
            Column(
                Modifier
                    .weight(1f)
                    .background(Color.Red)
            ) {
                Text(text = "Weight = 1", color = Color.White)
            }
            Column(
                Modifier
                    .weight(1f)
                    .background(Color.Blue)
            ) {
                Text(text = "Weight = 1", color = Color.White)
            }
            Column(
                Modifier
                    .weight(2f)
                    .background(Color.Green)
            ) {
                Text(text = "Weight = 2")
            }
        }
    }

    @Composable
    fun ColumnArrangement() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            horizontalAlignment = Alignment.Start,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceAround,
//            verticalArrangement = Arrangement.SpaceEvenly,
//            verticalArrangement = Arrangement.SpaceBetween,
//            verticalArrangement = Arrangement.Top,
//            verticalArrangement = Arrangement.Center,
//            verticalArrangement = Arrangement.Bottom,
        ) {
            Text(text = "Text 1", color = Color.Blue)
            Text(text = "Text 2", color = Color.Red)
            Text(text = "Text 3", color = Color.Green)
        }
    }

}