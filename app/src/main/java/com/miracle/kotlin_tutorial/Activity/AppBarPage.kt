package com.miracle.kotlin_tutorial.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miracle.kotlin_tutorial.R
import com.miracle.kotlin_tutorial.ui.theme.ColorAccent
import com.miracle.kotlin_tutorial.ui.theme.ColorPrimaryDark
import com.miracle.kotlin_tutorial.ui.theme.Kotlin_TutorialTheme
import com.miracle.kotlin_tutorial.ui.theme.White

class AppBarPage : ComponentActivity() {
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
                            text = "AppBar & Tabs",
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
                        titleText("AppBar with icon buttons :")
                        IconAppBar()

                        titleText("Appbar with Overflow menu :")
                        OverflowMenuAppBar()

                        titleText("Simple Text Tab :")
                        SimpleTextTab()

                        titleText("Icons Tab :")
                        IconsTab()

                        titleText("Icons & Text Tab :")
                        IconsTextTab()

                        titleText("Custom Tab :")
                        CustomTabs()

                        titleText("Custom AppBar with Tab :")
                        AppBarTabs()

                    }
                }
            }
        }
    }

    private @Composable
    fun AppBarTabs() {
        androidx.compose.material.Surface(elevation = 1.dp) {
            Column {
                IconAppBar()
                IconsTextTab()
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
    fun IconAppBar() {
        TopAppBar(
            title = {
                androidx.compose.material.Text(text = "TopAppBar")
            },
            elevation = 8.dp,
            backgroundColor = ColorAccent,
            contentColor = White,
            navigationIcon = {
                IconButton(onClick = { finish() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            },
            actions = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)
                }

                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Refresh, contentDescription = null)
                }

                IconButton(
                    onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Call, contentDescription = null)
                }
            }
        )
    }

    @Composable
    fun OverflowMenuAppBar() {
        var showMenu by remember { mutableStateOf(false) }
        TopAppBar(
            title = { androidx.compose.material.Text("Overflow") },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Favorite, contentDescription = null)
                }
                IconButton(onClick = { showMenu = !showMenu }) {
                    Icon(Icons.Default.MoreVert, contentDescription = null)
                }
                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false }
                ) {
                    DropdownMenuItem(onClick = { showMenu = !showMenu }) {
                        Icon(Icons.Filled.Refresh, contentDescription = null)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Refresh")
                    }
                    DropdownMenuItem(onClick = { showMenu = !showMenu }) {
                        Icon(Icons.Filled.Call, contentDescription = null)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Call")
                    }
                }
            }
        )
    }

    @Composable
    fun SimpleTextTab() {
        var selectedIndex by remember { mutableStateOf(0) }
        val list = listOf("Home", "Favorite", "Settings")
        TabRow(selectedTabIndex = selectedIndex,
            indicator = { tabPositions: List<TabPosition> ->
                tabPositions.forEachIndexed { index, tabPosition ->
                    println(
                        "index: $index, " +
                                "left: ${tabPosition.left}, " +
                                "right: ${tabPosition.right}, " +
                                "width: ${tabPosition.width}"
                    )
                }
                Box(
                    modifier = Modifier
                        .myTabIndicatorOffset(tabPositions[selectedIndex])
                        .height(4.dp)
                        .background(color = Color.Red)
                ) {}
            }) {
            list.forEachIndexed { index, text ->
                Tab(selected = selectedIndex == index,
                    onClick = { selectedIndex = index },
                    text = { androidx.compose.material.Text(text = text) }
                )
            }
        }
    }

    fun Modifier.myTabIndicatorOffset(
        currentTabPosition: TabPosition
    ): Modifier = composed(
        inspectorInfo = debugInspectorInfo {
            name = "tabIndicatorOffset"
            value = currentTabPosition
        }
    ) {
        val currentTabWidth by animateDpAsState(
            targetValue = currentTabPosition.width,
            animationSpec = tween(durationMillis = 5250, easing = FastOutSlowInEasing),
            label = "tab width"
        )
        val indicatorOffset by animateDpAsState(
            targetValue = currentTabPosition.left,
            animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
            label = "indicator offset"
        )
        fillMaxWidth()
            .wrapContentSize(Alignment.BottomStart)
            .offset(x = indicatorOffset)
            .width(currentTabWidth)
    }

    @Composable
    fun IconsTab() {
        var selectedIndex by remember { mutableStateOf(0) }
        val icons = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Settings)
        TabRow(
            selectedTabIndex = selectedIndex,
            backgroundColor = ColorAccent,
            contentColor = White,
            indicator = { tabPositions: List<TabPosition> ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex]),
                    height = 5.dp,
                    color = ColorPrimaryDark
                )
            }
        ) {
            icons.forEachIndexed { index, imageVector ->
                Tab(
                    selected = selectedIndex == index,
                    onClick = { selectedIndex = index },
                    icon = {
                        Icon(imageVector = imageVector, contentDescription = null)
                    })
            }
        }
    }

    @Composable
    fun IconsTextTab() {
        var selectedIndex by remember { mutableStateOf(0) }
        val tabContents = listOf(
            "Home" to Icons.Filled.Home,
            "Map" to Icons.Filled.Favorite,
            "Settings" to Icons.Filled.Settings
        )

        TabRow(
            selectedTabIndex = selectedIndex,
            backgroundColor = ColorAccent,
            contentColor = Color.White,
            indicator = { tabPositions: List<TabPosition> ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex]),
                    height = 5.dp,
                    color = ColorPrimaryDark
                )
            }
        ) {
            tabContents.forEachIndexed { index, pair: Pair<String, ImageVector> ->
                Tab(selected = selectedIndex == index, onClick = { selectedIndex = index },
                    text = { androidx.compose.material.Text(text = pair.first) },
                    icon = { Icon(imageVector = pair.second, contentDescription = null) }
                )
            }
        }
    }

    @Composable
    fun CustomTabs() {
        var selectedIndex by remember { mutableStateOf(0) }

        val list = listOf("Active", "Completed")

        TabRow(selectedTabIndex = selectedIndex,
            backgroundColor = ColorAccent,
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 8.dp)
                .clip(RoundedCornerShape(30))
                .background(ColorAccent)
                .padding(1.dp),
            indicator = { tabPositions: List<TabPosition> ->
                Box {}
            }
        ) {
            list.forEachIndexed { index, text ->
                val selected = selectedIndex == index
                Tab(
                    modifier = if (selected) Modifier
                        .clip(RoundedCornerShape(30))
                        .background(ColorPrimaryDark)
                    else Modifier
                        .clip(RoundedCornerShape(30))
                        .background(ColorAccent),
                    selected = selected,
                    onClick = { selectedIndex = index },
                    text = {
                        androidx.compose.material.Text(
                            text = text,
                            color = White
                        )
                    }
                )
            }
        }
    }

}