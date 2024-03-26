package com.miracle.kotlin_tutorial.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.kotlin_tutorial.R
import com.miracle.kotlin_tutorial.ui.theme.ColorAccent
import com.miracle.kotlin_tutorial.ui.theme.Kotlin_TutorialTheme
import com.miracle.kotlin_tutorial.ui.theme.White

class CheckBoxPage : ComponentActivity() {
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
                            text = "Check Box",
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

                        titleText("Simple Check Box :")
                        SimpleCheckbox()

                        titleText("Square Check Box :")
                        SquareCheckbox()

                        titleText("Round Check Box :")
                        RoundedCheckView()

                        titleText("Custom Check Box :")
                        var checked by remember { mutableStateOf(false) }
                        CustomCheckbox(
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )

                        titleText("Multi Selected Check Box :")
                        Checkboxes()

                    }
                }
            }
        }
    }

    @Composable
    fun SimpleCheckbox() {
        val checkedState = remember { mutableStateOf(true) }
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ){
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },

            )
            Text(text = "Checkbox Example")
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
    fun CustomCheckbox(
        checked: Boolean,
        onCheckedChange: (Boolean) -> Unit
    ) {
        IconButton(onClick = { onCheckedChange(!checked) }) {
            Image(
                painter = painterResource(id = R.drawable.checkbox_off_icon),
                contentDescription = "Unchecked",
                modifier = Modifier
                    .size(30.dp)
            )
            AnimatedVisibility(
                visible = checked,
                exit = shrinkOut(shrinkTowards = Alignment.TopStart) + fadeOut()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.checkbox_on_icon),
                    contentDescription = "Checked",
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
    }


    @Composable
    fun SquareCheckbox() {
        var isChecked by remember { mutableStateOf(false) }
        val checkboxColor: Color by animateColorAsState(if (isChecked) Color.Blue else Color.White)
        val density = LocalDensity.current
        val duration = 200
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(12.dp)
                .toggleable(
                    value = isChecked,
                    role = Role.Checkbox,
                    onValueChange = { isChecked = it }
                )
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(color = checkboxColor, shape = RoundedCornerShape(4.dp))
                    .border(width = 1.5.dp, color = Color.Blue, shape = RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.animation.AnimatedVisibility(
                    visible = isChecked,
                    enter = slideInHorizontally(animationSpec = tween(duration)) {
                        with(density) { (24f * -0.5).dp.roundToPx() }
                    } + expandHorizontally(
                        expandFrom = Alignment.Start,
                        animationSpec = tween(duration)
                    ),
                    exit = fadeOut()
                ) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "Checkbox label",
            )
        }
    }

    @Composable
    fun RoundedCheckView() {
        val isChecked = remember { mutableStateOf(false) }
        val checkedText = remember { mutableStateOf("unChecked") }
        val circleSize = remember { mutableStateOf(20.dp) }
        val circleThickness = remember { mutableStateOf(2.dp) }
        val color = remember { mutableStateOf(Color.Gray) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .toggleable(value = isChecked.value, role = Role.Checkbox) {
                    isChecked.value = it
                    if (isChecked.value) {
                        checkedText.value = "Checked"
                        circleSize.value = 30.dp
                        circleThickness.value = 3.dp
                        color.value = Color.Black
                    } else {
                        checkedText.value = "unChecked"
                        circleSize.value = 30.dp
                        circleThickness.value = 2.dp
                        color.value = Color.Gray
                    }
                }) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(circleSize.value)
                    .background(color.value)
                    .padding(circleThickness.value)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                if (isChecked.value) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "")
                }
            }

            Text(
                text = checkedText.value,
                color = color.value,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }


    @Composable
    fun Checkboxes() {
        val checkboxes = remember {
            mutableStateListOf(
                CheckboxInfo(
                    isChecked = false,
                    text = "Checkbox1"
                ),
                CheckboxInfo(
                    isChecked = false,
                    text = "Checkbox2"
                ),
                CheckboxInfo(
                    isChecked = false,
                    text = "Checkbox3"
                )
            )
        }

        var isCheckedCount = 0

        var triState by remember {
            mutableStateOf(ToggleableState.Off)
        }

        val toggleTriState = {
            triState = when (triState) {
                ToggleableState.Indeterminate -> ToggleableState.On
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Off -> ToggleableState.On
            }

            checkboxes.indices.forEach { index ->
                checkboxes[index] = checkboxes[index].copy(
                    isChecked = triState == ToggleableState.On
                )
            }
        }

        val parentCheckboxInteractionSource = remember {
            MutableInteractionSource()
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(
                    indication = null,
                    onClick = toggleTriState,
                    interactionSource = parentCheckboxInteractionSource
                )
        ) {
            TriStateCheckbox(
                state = triState,
                onClick = toggleTriState,
                interactionSource = parentCheckboxInteractionSource
            )

            Text(text = "ParentCheckbox")

        }

        checkboxes.forEachIndexed { index, info ->

            val onCheckChangeFun = {
                checkboxes[index] = info.copy(
                    isChecked = !info.isChecked
                )
            }

            if (info.isChecked) {
                isCheckedCount++
            }

            val childCheckboxInteractionSource = remember {
                MutableInteractionSource()
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 32.dp)
                    .clickable(
                        indication = null,
                        onClick = onCheckChangeFun,
                        interactionSource = childCheckboxInteractionSource
                    )
            ) {
                Checkbox(
                    checked = info.isChecked,
                    onCheckedChange = { isChecked ->
                        onCheckChangeFun()
                    },
                    interactionSource = childCheckboxInteractionSource
                )
                Text(text = info.text)

            }

        }

        if (checkboxes.all { it.isChecked }) {
            triState = ToggleableState.On
        } else if (checkboxes.all { !it.isChecked }) {
            triState = ToggleableState.Off
        } else if (checkboxes.any { it.isChecked }) {
            triState = ToggleableState.Indeterminate
        }

    }
}

data class CheckboxInfo(
    val isChecked: Boolean,
    val text: String
)