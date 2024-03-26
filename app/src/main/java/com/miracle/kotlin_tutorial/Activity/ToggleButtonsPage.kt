package com.miracle.kotlin_tutorial.Activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
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
import java.util.Locale

class ToggleButtonsPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_TutorialTheme {
                ToggleButtonsPageUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ToggleButtonsPageUI() {
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
                            text = "Toggle Buttons",
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

                        titleText("Simple Toggle Button :")
                        SimpleToggleButton()

                        titleText("Multi Toggle Button :")
                        var selectedOption by remember { mutableStateOf("Option 1") }
                        MultiToggleButton(
                            currentSelection = selectedOption,
                            onToggleChange = { newSelection ->
                                selectedOption = newSelection
                            }
                        )

                        titleText("Like & DisLike Toggle Button :")
                        LikeToggleButton()

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
    fun SimpleToggleButton() {
        var checked by remember { mutableStateOf(false) }
        val tint by animateColorAsState(if (checked) Color.LightGray else Color.Black)
        val textColor = if (checked) White else Color.LightGray
        IconToggleButton(
            checked = checked,
            onCheckedChange = { checked = it },
            modifier = Modifier
                .clip(CircleShape)
                .border(1.dp, Color.LightGray, CircleShape)
                .background(tint)

        ) {
            Text("M", color = textColor)
        }
    }

    @SuppressLint("UnusedTransitionTargetStateParameter")
    @Composable
    fun LikeToggleButton() {
        val checkedState = remember { mutableStateOf(false) }
        Row(
            Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .fillMaxWidth(),
            Arrangement.Center,
            Alignment.CenterVertically
        ) {
            IconToggleButton(
                checked = checkedState.value,
                onCheckedChange = {
                    checkedState.value = !checkedState.value
                },
                modifier = Modifier.padding(10.dp)
            ) {
                val transition = updateTransition(checkedState.value)
                val tint by transition.animateColor(label = "iconColor") { isChecked ->
                    if (isChecked) Color.Green else Color.Black
                }

                val size by transition.animateDp(
                    transitionSpec = {
                        if (false isTransitioningTo true) {
                            keyframes {
                                durationMillis = 250
                                30.dp at 0 with LinearOutSlowInEasing // for 0-15 ms
                                35.dp at 15 with FastOutLinearInEasing // for 15-75 ms
                                40.dp at 75 // ms
                                35.dp at 150 // ms
                            }
                        } else {
                            spring(stiffness = Spring.StiffnessVeryLow)
                        }
                    },
                    label = "Size"
                ) { 30.dp }

                Icon(
                    imageVector = if (checkedState.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = "Icon",
                    tint = tint,
                    modifier = Modifier.size(size)
                )
            }
            Text(
                text = if (checkedState.value) "Like" else "Dis Like",
                modifier = Modifier
                    .width(100.dp),
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
            )
        }
    }

    @Composable
    fun MultiToggleButton(
        currentSelection: String,
        onToggleChange: (String) -> Unit
    ) {
        val toggleStates = listOf("Option 1", "Option 2", "Option 3")
        val selectedTint = MaterialTheme.colorScheme.primary
        val unselectedTint = Color.Unspecified

        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .border(BorderStroke(1.dp, Color.LightGray))
        ) {
            toggleStates.forEachIndexed { index, toggleState ->
                val isSelected = currentSelection.lowercase() == toggleState.lowercase()
                val backgroundTint = if (isSelected) selectedTint else unselectedTint
                val textColor = if (isSelected) Color.White else Color.Unspecified

                if (index != 0) {
                    Divider(
                        color = Color.LightGray,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .background(backgroundTint)
                        .padding(vertical = 6.dp, horizontal = 8.dp)
                        .toggleable(
                            value = isSelected,
                            enabled = true,
                            onValueChange = { selected ->
                                if (selected) {
                                    onToggleChange(toggleState)
                                }
                            })
                ) {
                    Text(
                        toggleState.toCapital(),
                        color = textColor,
                        modifier = Modifier.padding(4.dp)
                    )
                }

            }
        }
    }

    fun String.toCapital(): String {
        return this.lowercase().replaceFirstChar { it.titlecase(Locale.getDefault()) }
    }
}