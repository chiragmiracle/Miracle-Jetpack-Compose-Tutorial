package com.miracle.kotlin_tutorial.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
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

class ButtonPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_TutorialTheme {
                ButtonPageUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ButtonPageUI() {
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
                            text = "Button Demo",
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
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(10.dp))
                        SimpleButton()
                        Spacer(modifier = Modifier.height(10.dp))
                        ButtonWithColor()
                        Spacer(modifier = Modifier.height(10.dp))
                        ButtonWithMultipleTextView()
                        Spacer(modifier = Modifier.height(10.dp))
                        ButtonWithIcon()
                        Spacer(modifier = Modifier.height(10.dp))
                        ButtonWithShape()
                        Spacer(modifier = Modifier.height(10.dp))
                        ButtonWithBorder()
                        Spacer(modifier = Modifier.height(10.dp))
                        ButtonWithElevation()
                        Spacer(modifier = Modifier.height(10.dp))
                        ButtonWithSizable()
                    }
                }
            }
        }
    }

    @Composable
    fun SimpleButton() {
        val context = LocalContext.current
        Button(onClick = {
            Toast
                .makeText(context, "Clicked Simple Button", Toast.LENGTH_SHORT)
                .show()
        }) {
            Text(text = "Simple Button")
        }
    }

    @Composable
    fun ButtonWithColor() {
        val context = LocalContext.current
        Button(
            onClick = {
                Toast
                    .makeText(context, "Clicked Button with background color", Toast.LENGTH_SHORT)
                    .show()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        )
        {
            Text(text = "Button with background color", color = Color.White)
        }
    }

    @Composable
    fun ButtonWithMultipleTextView() {
        val context = LocalContext.current
        Button(
            onClick = {
                Toast
                    .makeText(context, "Clicked Button with multiple textview", Toast.LENGTH_SHORT)
                    .show()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text(text = "Button ", color = Color.Magenta)
            Text(text = "With ", color = Color.Green)
            Text(text = "Multiple ", color = Color.Magenta)
            Text(text = "Textview ", color = Color.Green)
        }
    }

    @Composable
    fun ButtonWithIcon() {
        val context = LocalContext.current
        Button(onClick = {
            Toast
                .makeText(context, "Clicked Icon Button", Toast.LENGTH_SHORT)
                .show()
        }) {
            Image(
                painterResource(id = R.drawable.ic_button),
                contentDescription = "Button with icon",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier.size(20.dp)
            )
            Text(text = "Icon Button", Modifier.padding(start = 10.dp))
        }
    }

    @Composable
    fun ButtonWithShape() {
        val context = LocalContext.current
        Button(
            onClick = {
                Toast
                    .makeText(context, "Clicked Shape Button", Toast.LENGTH_SHORT)
                    .show()
            },
//            shape = RectangleShape // Rectangle Shape Button
//            shape = RoundedCornerShape(20.dp)  // Rounded Corner Shape Button
            shape = CutCornerShape(20) // Cut Corner Shape Button
        ) {
            Text(text = "Shape Button")
        }
    }

    @Composable
    fun ButtonWithBorder() {
        val context = LocalContext.current
        Button(
            onClick = {
                Toast
                    .makeText(context, "Clicked Border Button", Toast.LENGTH_SHORT)
                    .show()
            },
            border = BorderStroke(2.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(
                containerColor = ColorAccent,
            )
        ) {
            Text(text = "Border Button")
        }
    }

    @Composable
    fun ButtonWithElevation() {
        val context = LocalContext.current
        Button(
            onClick = {
                Toast
                    .makeText(context, "Clicked Elevation Button", Toast.LENGTH_SHORT)
                    .show()
            }, elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            )
        ) {
            Text(text = "Elevation Button")
        }
    }

    @Composable
    fun ButtonWithSizable() {
        val context = LocalContext.current
        Button(
            onClick = {
                Toast
                    .makeText(context, "Clicked Sizable Button", Toast.LENGTH_SHORT)
                    .show()
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
//                .fillMaxHeight() //full height
//                .fillMaxWidth() //full width
                .size(width = 250.dp, height = 50.dp)
        ) {
            Text(text = "Size Button")
        }
    }
}