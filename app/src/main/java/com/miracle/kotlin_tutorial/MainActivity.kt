package com.miracle.kotlin_tutorial

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.kotlin_tutorial.Activity.AppBarPage
import com.miracle.kotlin_tutorial.Activity.ButtonPage
import com.miracle.kotlin_tutorial.Activity.CheckBoxPage
import com.miracle.kotlin_tutorial.Activity.ChipPage
import com.miracle.kotlin_tutorial.Activity.ColumnPage
import com.miracle.kotlin_tutorial.Activity.DialogPage
import com.miracle.kotlin_tutorial.Activity.EditTextFieldPage
import com.miracle.kotlin_tutorial.Activity.ImageFieldPage
import com.miracle.kotlin_tutorial.Activity.ListGridPage
import com.miracle.kotlin_tutorial.Activity.ProgressIndicatorPage
import com.miracle.kotlin_tutorial.Activity.RadioButtonsPage
import com.miracle.kotlin_tutorial.Activity.RowPage
import com.miracle.kotlin_tutorial.Activity.SwitchPage
import com.miracle.kotlin_tutorial.Activity.TextFieldPage
import com.miracle.kotlin_tutorial.Activity.ToggleButtonsPage
import com.miracle.kotlin_tutorial.BottomNav.BottomNavigationPage
import com.miracle.kotlin_tutorial.ColorPicker.ColorPickerPage
import com.miracle.kotlin_tutorial.NavigationDrawer.NavDrawer
import com.miracle.kotlin_tutorial.ui.theme.ColorAccent
import com.miracle.kotlin_tutorial.ui.theme.Kotlin_TutorialTheme
import com.miracle.kotlin_tutorial.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_TutorialTheme {
                MainUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainUI() {
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
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(R.drawable.ic_row, "Row", onIntent = {
                                startActivity(
                                    Intent(
                                        this@MainActivity, RowPage::class.java
                                    )
                                )
                            })
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(R.drawable.ic_column, "Column", onIntent = {
                                startActivity(
                                    Intent(
                                        this@MainActivity, ColumnPage::class.java
                                    )
                                )
                            })
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(R.drawable.ic_font, "Text Field", onIntent = {
                                startActivity(
                                    Intent(
                                        this@MainActivity, TextFieldPage::class.java
                                    )
                                )
                            })
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(R.drawable.ic_image, "Image Field", onIntent = {
                                startActivity(
                                    Intent(
                                        this@MainActivity, ImageFieldPage::class.java
                                    )
                                )
                            })
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(R.drawable.ic_button, "Button", onIntent = {
                                startActivity(
                                    Intent(
                                        this@MainActivity, ButtonPage::class.java
                                    )
                                )
                            })
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(R.drawable.ic_edit_text, "Edit Text Field", onIntent = {
                                startActivity(
                                    Intent(
                                        this@MainActivity, EditTextFieldPage::class.java
                                    )
                                )
                            })
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(R.drawable.ic_listgrid, "List & Grid", onIntent = {
                                startActivity(
                                    Intent(
                                        this@MainActivity, ListGridPage::class.java
                                    )
                                )
                            })
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(
                                R.drawable.ic_progress,
                                "Progress Indicator",
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, ProgressIndicatorPage::class.java
                                        )
                                    )
                                })
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(
                                R.drawable.ic_checkbox,
                                "Check Box",
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, CheckBoxPage::class.java
                                        )
                                    )
                                })
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(
                                R.drawable.ic_rediobuttons,
                                "Radio Buttons",
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, RadioButtonsPage::class.java
                                        )
                                    )
                                })
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(
                                R.drawable.ic_switch,
                                "Switch",
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, SwitchPage::class.java
                                        )
                                    )
                                })
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(
                                R.drawable.ic_toggle,
                                "Toggle Buttons",
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, ToggleButtonsPage::class.java
                                        )
                                    )
                                })
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(
                                R.drawable.ic_bottombar,
                                "Bottom Navigation",
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, BottomNavigationPage::class.java
                                        )
                                    )
                                })
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(
                                R.drawable.ic_navdrawer,
                                "Navigation Drawer",
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, NavDrawer::class.java
                                        )
                                    )
                                })
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(
                                R.drawable.ic_appbar,
                                "AppBar & Tab",
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, AppBarPage::class.java
                                        )
                                    )
                                })
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(
                                R.drawable.ic_dialog,
                                "Dialog",
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, DialogPage::class.java
                                        )
                                    )
                                })
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(
                                R.drawable.ic_button,
                                "Chip Button",
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, ChipPage::class.java
                                        )
                                    )
                                })
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1F)
                                .fillMaxHeight(),
                        ) {
                            selectedButton(
                                R.drawable.ic_color,
                                "Color Picker",
                                onIntent = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity, ColorPickerPage::class.java
                                        )
                                    )
                                })
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                }
            }
        }
    }

    @Composable
    fun selectedButton(image: Int, name: String, onIntent: () -> Unit) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = ColorAccent,
            ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .clickable { onIntent() }
                .padding(10.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(White),
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = name,
                    color = White,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}