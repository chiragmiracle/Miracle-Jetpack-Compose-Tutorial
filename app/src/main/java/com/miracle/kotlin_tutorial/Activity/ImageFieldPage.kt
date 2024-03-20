package com.miracle.kotlin_tutorial.Activity

import android.os.Bundle
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
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

class ImageFieldPage : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_TutorialTheme {
                ImageFieldPageUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ImageFieldPageUI() {
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
                            text = "Image Field Demo",
                            color = Color.White,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(alignment = Alignment.Center)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .weight(weight = 1f, fill = false)
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(10.dp)
                    ) {
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Simple Image :",
                            color = Color.Black,
                            fontSize = 15.sp,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        SimpleImage()
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Circle Image View :",
                            color = Color.Black,
                            fontSize = 15.sp,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        CircleImageView()
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Round Corner Image View :",
                            color = Color.Black,
                            fontSize = 15.sp,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        RoundCornerImageView()
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Image With Background Color :",
                            color = Color.Black,
                            fontSize = 15.sp,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        ImageWithBackgroundColor()
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Image With Tint :",
                            color = Color.Black,
                            fontSize = 15.sp,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        ImageWithTint()
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Rotate Image :",
                            color = Color.Black,
                            fontSize = 15.sp,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        RotateImage()
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Opacity Image :",
                            color = Color.Black,
                            fontSize = 15.sp,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        OpacitiyDownImage()
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Inside Fit Image :",
                            color = Color.Black,
                            fontSize = 15.sp,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        InsideFitImage()
                    }
                }
            }
        }
    }

    @Composable
    fun SimpleImage() {
        Image(
            painter = painterResource(id = R.drawable.ic_image),
            contentDescription = "Andy Rubin",
            modifier = Modifier.size(50.dp)
        )
    }

    @Composable
    fun CircleImageView() {
        Image(
            painter = painterResource(R.drawable.ic_image),
            contentDescription = "Circle Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape) // clip to the circle shape
                .border(1.dp, Color.Gray, CircleShape)//optional
                .padding(10.dp)
        )
    }

    @Composable
    fun RoundCornerImageView() {
        Image(
            painter = painterResource(R.drawable.ic_image),
            contentDescription = "Round corner image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(10))
                .border(1.dp, Color.Gray, RoundedCornerShape(10))
                .padding(10.dp)
        )
    }

    @Composable
    fun ImageWithBackgroundColor() {
        Image(
            painter = painterResource(id = R.drawable.ic_image),
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .background(Color.DarkGray)
                .padding(10.dp)
        )
    }

    @Composable
    fun ImageWithTint() {
        Image(
            painter = painterResource(id = R.drawable.ic_image),
            contentDescription = "",
            colorFilter = ColorFilter.tint(Color.Red),
            modifier = Modifier
                .size(50.dp)
        )
    }

    @Composable
    fun RotateImage() {
        Image(
            painter = painterResource(id = R.drawable.ic_image),
            contentDescription = "",
            modifier = Modifier
                .rotate(135f)
                .padding(5.dp)
                .size(50.dp)
        )
    }

    @Composable
    fun OpacitiyDownImage() {
        Image(
            painter = painterResource(id = R.drawable.ic_image),
            contentDescription = "",
            modifier = Modifier
                .alpha(0.5f) //Down Opacity
                .padding(5.dp)
                .size(50.dp)
        )
    }

    @Composable
    fun InsideFitImage() {
        Image(
            painter = painterResource(id = R.drawable.ic_image),
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .background(Color.LightGray)
                .padding(10.dp),
            contentScale = ContentScale.Inside,
//            contentScale = ContentScale.None,
//            contentScale = ContentScale.Fit,
//            contentScale = ContentScale.Crop,
//            contentScale = ContentScale.FillBounds,
//            contentScale = ContentScale.FillHeight,
//            contentScale = ContentScale.FillWidth,
        )
    }
}