package com.miracle.kotlin_tutorial.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

class SwitchPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_TutorialTheme {
                EditTextFieldPageUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun EditTextFieldPageUI() {
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
                            text = "Switch",
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
                            .verticalScroll(rememberScrollState())
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(10.dp),
                    ) {

                        titleText("Simple Switch :")
                        SimpleSwitch()

                        titleText("Icon Switch :")
                        IconSwitch()

                        titleText("Change Color Switch :")
                        ChangeColorSwitch()

//                        titleText("Change Color Switch :")
//                        var value by remember { mutableStateOf(true) }
//                        DarkModeSwitch(value, Modifier.padding(24.dp)) { value = it }
//                        DarkModeSwitch(!value, Modifier.padding(24.dp)) { value = !it }


                    }
                }
            }
        }
    }

    @Composable
    private fun titleText(text: String) {
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth(),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
        )
        Spacer(modifier = Modifier.height(8.dp))
    }

    @Composable
    fun SimpleSwitch() {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )
    }

    @Composable
    fun IconSwitch() {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            },
            thumbContent = if (checked) {
                {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize),
                    )
                }
            } else {
                {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize),
                    )
                }
            }
        )
    }

    @Composable
    fun ChangeColorSwitch() {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.hsl(154f, 0.64f, 0.5f),
                checkedTrackColor = Color.hsl(139f, 0.25f, 0.24f),
                uncheckedThumbColor = Color.hsl(360f, 1.00f, 0.6f),
                uncheckedTrackColor = Color.hsl(360f, 0.25f, 0.3f),
            )
        )
    }


//    @Composable
//    fun DarkModeSwitch(checked: Boolean, modifier: Modifier, onCheckedChanged: (Boolean) -> Unit) {
//
//        val switchWidth = 160.dp
//        val switchHeight = 64.dp
//        val handleSize = 52.dp
//        val handlePadding = 10.dp
//
//        val valueToOffset = if (checked) 1f else 0f
//        val offset = remember { Animatable(valueToOffset) }
//        val scope = rememberCoroutineScope()
//
//        DisposableEffect(checked) {
//            if (offset.targetValue != valueToOffset) {
//                scope.launch {
//                    offset.animateTo(valueToOffset, animationSpec = tween(1000))
//                }
//            }
//            onDispose { }
//        }
//
//        Box(
//            contentAlignment = Alignment.CenterStart,
//            modifier = modifier
//                .width(switchWidth)
//                .height(switchHeight)
//                .clip(RoundedCornerShape(switchHeight))
//                .background(lerp(BlueSky, NightSky, offset.value))
//                .border(3.dp, BorderColor, RoundedCornerShape(switchHeight))
//                .toggleable(
//                    value = checked,
//                    onValueChange = onCheckedChanged,
//                    role = Role.Switch,
//                    interactionSource = remember { MutableInteractionSource() },
//                    indication = null
//                )
//        ) {
//            val backgroundPainter = painterResource(R.drawable.background)
//            Canvas(modifier = Modifier.fillMaxSize()) {
//                with(backgroundPainter) {
//                    val scale = size.width / intrinsicSize.width
//                    val scaledHeight = intrinsicSize.height * scale
//                    translate(top = (size.height - scaledHeight) * (1f - offset.value)) {
//                        draw(Size(size.width, scaledHeight))
//                    }
//                }
//            }
//
//            Image(
//                painter = painterResource(R.drawable.glow),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .size(switchWidth)
//                    .graphicsLayer {
//                        scaleX = 1.2f
//                        scaleY = scaleX
//                        translationX = lerp(
//                            -size.width * 0.5f + handlePadding.toPx() + handleSize.toPx() * 0.5f,
//                            switchWidth.toPx() - size.width * 0.5f - handlePadding.toPx() - handleSize.toPx() * 0.5f,
//                            offset.value
//                        )
//                    }
//            )
//
//            Box(
//                modifier = Modifier
//                    .padding(horizontal = handlePadding)
//                    .size(handleSize)
//                    .offset(x = (switchWidth - handleSize - handlePadding * 2f) * offset.value)
//                    .paint(painterResource(R.drawable.sun))
//                    .clip(CircleShape)
//            ) {
//                Image(
//                    painter = painterResource(R.drawable.moon),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(handleSize)
//                        .graphicsLayer {
//                            translationX = size.width * (1f - offset.value)
//                        }
//                )
//            }
//        }
//    }

}