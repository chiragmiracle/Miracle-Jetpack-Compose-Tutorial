package com.miracle.kotlin_tutorial.BottomNav.Custom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.miracle.kotlin_tutorial.R
import com.miracle.kotlin_tutorial.ui.theme.ColorAccent
import com.miracle.kotlin_tutorial.ui.theme.Kotlin_TutorialTheme
import com.miracle.kotlin_tutorial.ui.theme.White

class CustomBottomNav : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_TutorialTheme {
                ButtonPageUI()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ButtonPageUI() {
        Kotlin_TutorialTheme {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { BottomBar(navController = navController) }
            ) {
                Modifier.padding(it)
                BottomNavGraph(
                    navController = navController
                )
            }
        }
    }

    @Composable
    fun BottomNavGraph(
        navController: NavHostController
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomBarScreen.Home.route
        ) {
            composable(route = BottomBarScreen.Home.route) {
                HomeScreen()
            }
            composable(route = BottomBarScreen.Report.route) {
                ReportScreen()
            }
            composable(route = BottomBarScreen.Profile.route) {
                ProfileScreen()
            }
        }
    }

    @Composable
    fun HomeScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.DarkGray)
                .wrapContentSize(Alignment.Center)
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
                        text = "Home Screen",
                        color = Color.White,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(alignment = Alignment.Center)
                    )
                }
            }
        }
    }

    @Composable
    fun ReportScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.DarkGray)
                .wrapContentSize(Alignment.Center)
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
                        text = "Report Screen",
                        color = Color.White,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(alignment = Alignment.Center)
                    )
                }
            }
        }
    }

    @Composable
    fun ProfileScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.DarkGray)
                .wrapContentSize(Alignment.Center)
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
                        text = "Profile Screen",
                        color = Color.White,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(alignment = Alignment.Center)
                    )
                }
            }
        }
    }

    @Composable
    fun BottomBar(navController: NavHostController) {
        val screens = listOf(
            BottomBarScreen.Home,
            BottomBarScreen.Report,
            BottomBarScreen.Profile
        )

        val navStackBackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navStackBackEntry?.destination

        Row(
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 40.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(Color.White)
                .fillMaxWidth()
                .height(60.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }

    }

    @Composable
    fun RowScope.AddItem(
        screen: BottomBarScreen,
        currentDestination: NavDestination?,
        navController: NavHostController
    ) {
        val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
        val background =
            if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.6f) else Color.Transparent
        val contentColor =
            if (selected) Color.White else Color.Black
        Box(
            modifier = Modifier
                .height(40.dp)
                .clip(CircleShape)
                .background(background)
                .clickable(onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                })
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    painter = painterResource(id = if (selected) screen.icon_focused else screen.icon),
                    contentDescription = "icon",
                    tint = contentColor
                )
                AnimatedVisibility(visible = selected) {
                    Text(
                        text = screen.title,
                        color = contentColor
                    )
                }
            }
        }
    }

}

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
) {
    // for home
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_bottom_home,
        icon_focused = R.drawable.ic_bottom_home_focused,
    )

    // for report
    object Report : BottomBarScreen(
        route = "report",
        title = "Report",
        icon = R.drawable.ic_bottom_report,
        icon_focused = R.drawable.ic_bottom_report_focused,
    )

    // for report
    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.ic_bottom_profile,
        icon_focused = R.drawable.ic_bottom_profile_focused,
    )

}