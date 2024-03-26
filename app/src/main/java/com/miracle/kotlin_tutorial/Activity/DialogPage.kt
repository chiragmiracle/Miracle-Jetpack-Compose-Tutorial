package com.miracle.kotlin_tutorial.Activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.miracle.kotlin_tutorial.R
import com.miracle.kotlin_tutorial.ui.theme.ColorAccent
import com.miracle.kotlin_tutorial.ui.theme.Kotlin_TutorialTheme
import com.miracle.kotlin_tutorial.ui.theme.White

class DialogPage : ComponentActivity() {


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
                            text = "Dialog",
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
                        Alignment.CenterHorizontally
                    ) {

                        var simpleAlertDialog by remember { mutableStateOf(false) }
                        Button(onClick = {
                            simpleAlertDialog = !simpleAlertDialog
                        }) {
                            Text(text = "Simple Alert Dialog")
                        }
                        if (simpleAlertDialog) {
                            SimpleAlertDialog {
                                simpleAlertDialog = !simpleAlertDialog
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        var customAlertDialog by remember { mutableStateOf(false) }
                        Button(onClick = {
                            customAlertDialog = !customAlertDialog
                        }) {
                            Text(text = "Custom Alert Dialog")
                        }
                        if (customAlertDialog) {
                            CustomAlertDialog {
                                customAlertDialog = !customAlertDialog
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        var simpleDialog by remember { mutableStateOf(false) }
                        Button(onClick = {
                            simpleDialog = !simpleDialog
                        }) {
                            Text(text = "Simple Dialog")
                        }
                        if (simpleDialog) {
                            SimpleDialog {
                                simpleDialog = !simpleDialog
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        CustomDialog()

                        Spacer(modifier = Modifier.height(10.dp))

                        var loadingDialog by remember { mutableStateOf(false) }
                        Button(onClick = {
                            loadingDialog = !loadingDialog
                        }) {
                            Text(text = "Loading Dialog")
                        }
                        if (loadingDialog) {
                            LoadingDialog {
                                loadingDialog = !loadingDialog
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        var inputDialog by remember { mutableStateOf(false) }
                        Button(onClick = {
                            inputDialog = !inputDialog
                        }) {
                            Text(text = "Input Dialog")
                        }
                        if (inputDialog) {
                            InputDialog {
                                inputDialog = !inputDialog
                            }
                        }
                    }
                }
            }
        }
    }

    private @Composable
    fun CustomDialog() {
        val context = LocalContext.current
        val isInPreview = isInPreview
        var customDialog by remember { mutableStateOf(false) }
        Button(onClick = {
            customDialog = !customDialog
        }) {
            Text(text = "Custom Dialog")
        }
        if (customDialog) {
            CustomDialogMethod(
                onDismiss = {
                    customDialog = !customDialog
                    if (!isInPreview) {
                        Toast.makeText(context, "Dialog dismissed!", Toast.LENGTH_SHORT)
                            .show()
                    }
                },
                onNegativeClick = {
                    customDialog = !customDialog
                    if (!isInPreview) {
                        Toast.makeText(context, "Negative Button Clicked!", Toast.LENGTH_SHORT)
                            .show()
                    }
                },
                onPositiveClick = {
                    customDialog = !customDialog
                    if (!isInPreview) {
                        Toast.makeText(context, "Positive Button Clicked!", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            )
        }
    }

    @SuppressLint("UnrememberedMutableInteractionSource")
    @Composable
    private fun CustomDialogMethod(
        onDismiss: () -> Unit,
        onNegativeClick: () -> Unit,
        onPositiveClick: () -> Unit
    ) {
        Dialog(onDismissRequest = onDismiss) {
            val color = Color(0xff4DB6AC)
            Card(elevation = 8.dp, shape = RoundedCornerShape(12.dp)) {
                Column {
                    // Header
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                            .background(color)
                    ) {
                        Icon(
                            tint = Color.White,
                            painter = painterResource(id = R.drawable.ic_baseline_location_on_48),
                            contentDescription = null,
                            modifier = Modifier
                                .graphicsLayer(scaleX = 1.2f, scaleY = 1.2f)
                                .align(
                                    Alignment.Center
                                )
                        )
                    }

                    Column(modifier = Modifier.padding(16.dp)) {
                        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                            androidx.compose.material.Text("To send a nearby place or your location, allow access to your location.")
                        }
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            androidx.compose.material.Text(
                                text = "NOT NOW", color = color,
                                modifier = Modifier
                                    .clickable(
                                        interactionSource = MutableInteractionSource(),
                                        indication = rememberRipple(color = Color.DarkGray),
                                        onClick = onNegativeClick
                                    )
                                    .padding(8.dp)
                            )

                            Spacer(modifier = Modifier.width(4.dp))
                            androidx.compose.material.Text(
                                text = "CONTINUE", color = color,
                                modifier = Modifier
                                    .clickable(
                                        interactionSource = MutableInteractionSource(),
                                        indication = rememberRipple(color = Color.DarkGray),
                                        onClick = onPositiveClick
                                    )
                                    .padding(8.dp)
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun SimpleDialog(onDismiss: () -> Unit) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties()
        ) {
            Surface(elevation = 8.dp, shape = RoundedCornerShape(12.dp)) {
                Column(
                    modifier = Modifier
                        .width(400.dp)
                        .wrapContentHeight()
                        .background(Color.White)
                        .padding(8.dp)
                ) {

                    Text(
                        text = "Dialog Title",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(8.dp)
                    )

                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(
                            text = "Alert Dialog Details.....",
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row {
                        TextButton(
                            onClick = onDismiss,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text(text = "Cancel")
                        }
                        TextButton(
                            onClick = onDismiss,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text(text = "OK")
                        }
                    }
                }
            }
        }
    }

    private @Composable
    fun CustomAlertDialog(onDismiss: () -> Unit) {
        androidx.compose.material.AlertDialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = false,
                securePolicy = SecureFlagPolicy.Inherit
            ),
            title = {
                androidx.compose.material.Text(
                    "AlertDialog with Style",
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(text = "Alert Dialog Details.....")
            },
            buttons = {
                OutlinedButton(
                    shape = RoundedCornerShape(percent = 30),
                    onClick = onDismiss,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth()
                ) {
                    androidx.compose.material.Text(text = "Cancel", color = ColorAccent)
                }
                OutlinedButton(
                    shape = RoundedCornerShape(percent = 30),
                    onClick = onDismiss,
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = ColorAccent,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth()
                ) {
                    androidx.compose.material.Text(text = "OK")
                }
            }
        )
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
    private fun SimpleAlertDialog(onDismiss: () -> Unit) {
        AlertDialog(
            onDismissRequest = onDismiss,
            dismissButton = {
                TextButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Text(text = "Cancel")
                }
            },
            confirmButton = {
                TextButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Text(text = "OK")
                }
            },
            title = {
                Text(text = "Alert Dialog Title", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            },
            text = {
                Text(text = "Alert Dialog Details.....")
            }
        )
    }

    @Composable
    fun LoadingDialog(onDismiss: () -> Unit) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier,
                elevation = 8.dp
            ) {
                Column(
                    Modifier
                        .background(Color.White)
                        .padding(12.dp)
                ) {
                    Text(
                        text = "Loading.. Please wait..",
                        Modifier
                            .padding(8.dp), textAlign = TextAlign.Center
                    )
                    CircularProgressIndicator(
                        strokeWidth = 4.dp,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(8.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun InputDialog(onDismiss: () -> Unit) {
        val context = LocalContext.current
        var searchedFood by remember {
            mutableStateOf("")
        }

        Dialog(onDismissRequest = { onDismiss() }) {
            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = 8.dp
            ) {
                Column(
                    Modifier
                        .padding(15.dp)
                        .background(Color.White)
                ) {
                    Text(
                        text = "Enter your favorite food name.",
                        modifier = Modifier.padding(8.dp),
                        fontSize = 20.sp
                    )

                    OutlinedTextField(
                        value = searchedFood,
                        onValueChange = { searchedFood = it }, modifier = Modifier.padding(8.dp),
                        label = { Text("Favorite Food") }
                    )

                    Row {
                        OutlinedButton(
                            onClick = { onDismiss() },
                            border = BorderStroke(1.dp, ColorAccent),
                            shape = RoundedCornerShape(50),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .weight(1F)
                        ) {
                            Text(text = "Cancel")
                        }
                        Button(
                            onClick = {
                                Toast.makeText(context, searchedFood, Toast.LENGTH_SHORT).show()
                                onDismiss()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .weight(1F)
                        ) {
                            Text(text = "Search")
                        }
                    }
                }
            }
        }
    }


}

@Stable
val isInPreview @Composable get() = LocalInspectionMode.current