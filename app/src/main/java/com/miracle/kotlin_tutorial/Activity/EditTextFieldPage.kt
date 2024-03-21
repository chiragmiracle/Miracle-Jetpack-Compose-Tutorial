package com.miracle.kotlin_tutorial.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFontLoader
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.kotlin_tutorial.R
import com.miracle.kotlin_tutorial.ui.theme.BlueLight
import com.miracle.kotlin_tutorial.ui.theme.ColorAccent
import com.miracle.kotlin_tutorial.ui.theme.Kotlin_TutorialTheme
import com.miracle.kotlin_tutorial.ui.theme.White

class EditTextFieldPage : ComponentActivity() {
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
                            text = "Edit Text Field Demo",
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
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        titleText("Simple Text Field :")
                        SimpleTextField()

                        titleText("Label And Hint Text Field :")
                        LabelAndPlaceHolder()

                        titleText("InputType Text Field :")
                        TextFieldWithInputType()

                        titleText("OutLine Text Field :")
                        OutLineTextFieldSample()

                        titleText("Icon Text Field :")
                        TextFieldWithIcons()

                        titleText("Error Text Field :")
                        TextFieldWithError()

                        titleText("Custom Shape Text Field :")
                        TextFieldWithCustomShape()

                        titleText("OTP Text Field :")
                        OTPTextField()

                        titleText("Auto Sizable Text Field :")
                        AutoSizableTextField()

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
            fontSize = 15.sp,
            textAlign = TextAlign.Start,
        )
        Spacer(modifier = Modifier.height(8.dp))
    }

    @Composable
    fun SimpleTextField() {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            }
        )
    }

    @Composable
    fun LabelAndPlaceHolder() {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text(text = "Your Label") },
            placeholder = { Text(text = "Your Placeholder/Hint") },
        )
    }

    @Composable
    fun TextFieldWithInputType() {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = text,
            label = { Text(text = "Number Input Type") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { it ->
                text = it
            }
        )
    }

    @Composable
    fun OutLineTextFieldSample() {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = text,
            label = { Text(text = "Enter Your Name") },
            onValueChange = {
                text = it
            }
        )
    }

    @Composable
    fun TextFieldWithIcons() {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        return OutlinedTextField(
            value = text,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "emailIcon"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
            onValueChange = {
                text = it
            },
            label = { Text(text = "Email address") },
            shape = RoundedCornerShape(30.dp),
            placeholder = { Text(text = "Enter your E-mail") },
        )
    }

    @Composable
    fun TextFieldWithError() {
        var text by rememberSaveable { mutableStateOf("") }
        var isError by rememberSaveable { mutableStateOf(false) }
        val charLimit = 10

        fun validate(text: String) {
            isError = text.length > charLimit
        }

        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                validate(text)
            },
            label = { Text(text = "Enter Text") },
            singleLine = true,
            isError = isError,
            supportingText = {
                if (isError) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Limit: ${text.length}/$charLimit",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            trailingIcon = {
                if (isError)
                    Icon(
                        Icons.Default.Info, "Error",
                        tint = MaterialTheme.colorScheme.error,
                        modifier = Modifier.rotate(180f)

                    )
            },
            keyboardActions = KeyboardActions { validate(text) },
        )
    }

    @Composable
    fun TextFieldWithCustomShape() {
        Column {
            var textState by remember { mutableStateOf("") }
            val maxLength = 30
            val lightBlue = Color(0xffd8e6ff)
            val blue = Color(0xff76a9ff)
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 0.dp, horizontal = 40.dp),
                value = textState,
                onValueChange = {
                    if (it.length <= maxLength) textState = it
                },
                colors = TextFieldDefaults.colors(
                    ColorAccent,
                    unfocusedContainerColor = BlueLight,
                    focusedContainerColor = BlueLight,
                    cursorColor = ColorAccent,
                    disabledLabelColor = lightBlue,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                //            shape = RectangleShape, // Rectangle Shape Button
//            shape = RoundedCornerShape(20.dp),  // Rounded Corner Shape Button
                shape = CutCornerShape(20), // Cut Corner Shape Button
                singleLine = true,
                trailingIcon = {
                    if (textState.isNotEmpty()) {
                        IconButton(onClick = { textState = "" }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null,
                            )
                        }
                    }
                },
            )
            Text(
                text = "${textState.length} / $maxLength",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 40.dp),
                textAlign = TextAlign.End,
                color = blue
            )
        }
    }

    @Composable
    private fun OTPTextField() {
        var otpText by remember { mutableStateOf("") }

        BasicTextField(
            value = otpText,
            onValueChange = {
                if (it.length <= 6) { // Limiting the length to 6 characters
                    otpText = it
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            decorationBox = {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    otpText.forEachIndexed { index, char ->
                        DuckieTextFieldCharContainer(
                            text = char,
                            isFocused = index == otpText.lastIndex,
                        )
                    }
                    repeat(6 - otpText.length) {
                        DuckieTextFieldCharContainer(
                            text = ' ',
                            isFocused = false,
                        )
                    }
                }
            },
        )
    }

    @Composable
    private fun DuckieTextFieldCharContainer(
        modifier: Modifier = Modifier,
        text: Char,
        isFocused: Boolean,
    ) {
        val shape = remember { RoundedCornerShape(4.dp) }
        Box(
            modifier = modifier
                .size(
                    width = 40.dp,
                    height = 40.dp,
                )
                .background(
                    color = BlueLight,
                    shape = shape,
                )
                .run {
                    if (isFocused) {
                        border(
                            width = 1.dp,
                            color = ColorAccent,
                            shape = shape,
                        )
                    } else {
                        this
                    }
                },
            contentAlignment = Alignment.Center,
        ) {
            Text(text = text.toString())
        }
    }

    @Composable
    fun AutoSizableTextField() {
        var text by remember { mutableStateOf("") }
        BoxWithConstraints(
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 40.dp)
                .height(100.dp)
        ) {
            var nFontSize = 30.sp

            val calculateParagraph = @Composable {
                Paragraph(
                    text = text,
                    style = TextStyle(fontSize = nFontSize),
                    density = LocalDensity.current,
                    resourceLoader = LocalFontLoader.current,
                    maxLines = Int.MAX_VALUE,
                    width = with(LocalDensity.current) { maxWidth.toPx() }
                )
            }

            var intrinsics = calculateParagraph()
            with(LocalDensity.current) {
                while ((intrinsics.height.toDp() > maxHeight || intrinsics.didExceedMaxLines) && nFontSize >= 10.sp) {
                    nFontSize *= 0.9f
                    intrinsics = calculateParagraph()
                }
            }

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.fillMaxSize(),
                label = { Text(text = "Enter Text") },
                shape = RoundedCornerShape(8.dp),
                maxLines = Int.MAX_VALUE,
                textStyle = TextStyle(fontSize = nFontSize),
            )
        }
    }


}