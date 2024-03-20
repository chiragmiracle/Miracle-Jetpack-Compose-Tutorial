package com.miracle.kotlin_tutorial.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.kotlin_tutorial.R
import com.miracle.kotlin_tutorial.ui.theme.ColorAccent
import com.miracle.kotlin_tutorial.ui.theme.Kotlin_TutorialTheme
import com.miracle.kotlin_tutorial.ui.theme.White


class TextFieldPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_TutorialTheme {
                TextFieldPageUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TextFieldPageUI() {
        Kotlin_TutorialTheme {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
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
                            text = "Text Field Demo",
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
                        Spacer(modifier = Modifier.height(15.dp))
                        SimpleText()
                        Spacer(modifier = Modifier.height(15.dp))
                        StringResourceText()
                        Spacer(modifier = Modifier.height(15.dp))
                        stylingText()
                        Spacer(modifier = Modifier.height(15.dp))
                        customStylingText()
                        Spacer(modifier = Modifier.height(15.dp))
                        setAlignText()
                        Spacer(modifier = Modifier.height(15.dp))
                        showTextShadow()
                        Spacer(modifier = Modifier.height(15.dp))
                        setTextModifiers()
                        Spacer(modifier = Modifier.height(15.dp))
                        TextWithShape()
                        Spacer(modifier = Modifier.height(15.dp))
                        setTextWithLine()
                        Spacer(modifier = Modifier.height(15.dp))
                        setSingleLineText()
                    }
                }
            }
        }
    }

    @Composable
    fun SimpleText() {
        Text("Simple Text")
    }

    @Composable
    fun StringResourceText() {
        Text(stringResource(R.string.StringResourceText))
    }

    @Composable
    fun stylingText() {
        Text("Styling Text", style = MaterialTheme.typography.titleLarge)
    }

    @Composable
    fun customStylingText() {
        val myHeaderStyle = TextStyle(
            color = Color.Red,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace,
            fontStyle = FontStyle.Italic,
            letterSpacing = 0.25.sp
        )
        Text(
            text = "Custom Styling Text",
            style = myHeaderStyle,
            modifier = Modifier.background(color = Color.Yellow)
        )
    }

    @Composable
    fun setAlignText() {
        val myHeaderStyle = TextStyle(
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Normal,
            letterSpacing = 0.25.sp
        )
        Text(
            text = "Align Text",
            style = myHeaderStyle,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }

    @Composable
    fun showTextShadow() {
        Text(
            text = "Show Text Shadow", color = Color.Red, style = TextStyle(
                fontSize = 24.sp, shadow = Shadow(
                    color = Color.Blue, offset = Offset(5.0f, 10f), blurRadius = 5f
                )
            )
        )
    }

    @Composable
    fun setTextModifiers() {
        val GradientColors = listOf(Color.Cyan, Color.Blue, Color.Red, Color.Yellow)
        Text(
            text = "Text Modifiers With Gradient Background",
            color = Color.Red,
            modifier = Modifier
                .background(
                    Brush.linearGradient(
                        colors = GradientColors
                    )
                )
                .padding(10.dp)
                .clip(RoundedCornerShape((7.dp)))
                .background(Color.DarkGray)
                .padding(10.dp),
        )

    }

    @Composable
    fun setTextWithLine() {
        Text(
            text = " Jetpack Compose — Text composable. Text composable is used to show the text on the screen.".repeat(
                10
            ),
            color = Color.Black,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
//            softWrap = false //set Text With Over Flow And Softwrap
        )
    }

    @Composable
    fun TextWithShape() {
        Text(
            text = "Text with round border",
            color = Color.Black,
            modifier = Modifier
                .padding(Dp(10f))
                .border(2.dp, SolidColor(Color.Black), RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(25.dp))
                .background(Color.LightGray)
                .padding(Dp(15f))
        )
    }

    @Composable
    fun setSingleLineText() {
        val context = LocalContext.current
        Text(
            text = "Clickable Text",
            modifier = Modifier
                .padding(horizontal = 0.dp, vertical = 10.dp)
                .clickable(enabled = true, onClickLabel = "Click", onClick = {
                    Toast
                        .makeText(context, "Clicked", Toast.LENGTH_SHORT)
                        .show()
                }),
            color = Color.Red
        )
    }

}