package com.miracle.kotlin_tutorial.NavigationDrawer.CustomeNav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.miracle.kotlin_tutorial.ui.theme.Kotlin_TutorialTheme

class CustomNavDrawer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_TutorialTheme {
                CustomNavDrawerUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun CustomNavDrawerUI() {

    }

}