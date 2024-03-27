package com.miracle.kotlin_tutorial.Activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
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
import androidx.compose.ui.res.colorResource
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

class ChipPage : ComponentActivity() {


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
                            text = "Chip Button",
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
                        Arrangement.Center,
                    ) {
                        titleText("Assist Chip :")
                        AssistChipButton()

                        titleText("Filter Chip :")
                        FilterChipButton()

                        titleText("Elevated Filter Chip :")
                        ElevatedFilterChipButton()

                        titleText("Input Chip :")
                        InputChipButton()

                        titleText("Suggestion Chip :")
                        SuggestionChipButton()

                        titleText("Custom Chip :")
                        ChipsCustom()

                    }
                }
            }
        }
    }

    @Composable
    fun AssistChipButton() {
        AssistChip(
            onClick = { Log.d("Assist chip", "hello world") },
            label = { Text("Assist chip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = "Localized description",
                    Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ElevatedFilterChipButton() {
        var selected by remember { mutableStateOf(false) }
        ElevatedFilterChip(
            selected = selected,
            onClick = { selected = !selected },
            label = { Text("Elevated Filter chip") },
            leadingIcon = if (selected) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Localized Description",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FilterChipButton() {
        var selected by remember { mutableStateOf(false) }
        FilterChip(
            onClick = { selected = !selected },
            label = {
                Text("Filter chip")
            },
            selected = selected,
            leadingIcon = if (selected) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            },
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun InputChipButton() {
        var enabled by remember { mutableStateOf(true) }
        if (!enabled) return
        InputChip(
            onClick = {
//                enabled = !enabled // Remove Chip Button
            },
            label = { Text(text = "Input Chip") },
            selected = enabled,
            avatar = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "Localized description",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Localized description",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            },
        )
    }

    @Composable
    fun SuggestionChipButton() {
        SuggestionChip(
            onClick = { },
            label = { Text("Suggestion chip") }
        )
    }

    @Composable
    private fun CustomImageChip(
        text: String,
        imageId: Int,
        selected: Boolean,
        modifier: Modifier = Modifier
    ) {
        Surface(
            color = when {
                selected -> MaterialTheme.colors.primary
                else -> Color.Gray
            },
            contentColor = when {
                selected -> MaterialTheme.colors.onPrimary
                else -> Color.LightGray
            },
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(
                width = 1.dp,
                color = when {
                    selected -> MaterialTheme.colors.primary
                    else -> Color.LightGray
                }
            ),
            modifier = modifier
        ) {
            Row(modifier = Modifier) {
                Image(
                    painter = painterResource(imageId),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(20.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = text,
                    color = Color.White,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(end = 8.dp, top = 8.dp, bottom = 8.dp)
                )
            }
        }
    }

    @Composable
    fun ChipsCustom() {
        Column {
            Row() {
                CustomChip(
                    selected = true,
                    text = "Chip",
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                CustomChip(
                    selected = false,
                    text = "Inactive",
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                CustomImageChip(
                    text = "custom",
                    imageId = R.drawable.logo,
                    selected = true
                )
                Spacer(modifier = Modifier.padding(8.dp))
                CustomImageChip(
                    text = "custom2",
                    imageId = R.drawable.logo,
                    selected = false
                )
            }
            Row(
                modifier = Modifier
                .padding(vertical = 10.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .clip(CircleShape)
                ) {
                    Text(text = "Chip button")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = {},
                    enabled = false,
                    modifier = Modifier
                        .clip(CircleShape)
                ) {
                    Text(text = "Disabled chip")
                }
            }
        }
    }

    @Composable
    fun CustomChip(
        selected: Boolean,
        text: String,
        modifier: Modifier = Modifier
    ) {
        Surface(
            color = when {
                selected -> MaterialTheme.colors.onSurface
                else -> Color.Gray
            },
            contentColor = when {
                selected -> MaterialTheme.colors.onPrimary
                else -> Color.LightGray
            },
            shape = CircleShape,
            border = BorderStroke(
                width = 1.dp,
                color = when {
                    selected -> MaterialTheme.colors.primary
                    else -> Color.LightGray
                }
            ),
            modifier = modifier
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )

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

}