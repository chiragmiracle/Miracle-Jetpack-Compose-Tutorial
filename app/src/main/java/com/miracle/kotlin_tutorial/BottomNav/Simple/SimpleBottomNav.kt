package com.miracle.kotlin_tutorial.BottomNav.Simple

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.miracle.kotlin_tutorial.R
import com.miracle.kotlin_tutorial.ui.theme.ColorAccent
import com.miracle.kotlin_tutorial.ui.theme.ColorPrimary
import com.miracle.kotlin_tutorial.ui.theme.Kotlin_TutorialTheme
import com.miracle.kotlin_tutorial.ui.theme.White

class SimpleBottomNav : ComponentActivity() {

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
            val navController: NavHostController = rememberNavController()
            var buttonsVisible = remember { mutableStateOf(true) }
            Scaffold(
                bottomBar = {
                    BottomBar(
                        navController = navController,
                        state = buttonsVisible,
                        modifier = Modifier
                    )
                }) { paddingValues ->
                Box(
                    modifier = Modifier.padding(paddingValues)
                ) {
                    NavigationGraph(navController = navController)
                }
            }
        }
    }


    @Composable
    fun BottomBar(
        navController: NavHostController,
        state: MutableState<Boolean>,
        modifier: Modifier = Modifier
    ) {
        val screens = listOf(
            Destinations.HomeScreen, Destinations.Favourite, Destinations.Notification
        )

        NavigationBar(
            modifier = modifier,
            containerColor = Color.Black,
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            screens.forEach { screen ->

                NavigationBarItem(
                    label = {
                        Text(text = screen.title!!)
                    },
                    icon = {
                        Icon(imageVector = screen.icon!!, contentDescription = "")
                    },
                    selected = currentRoute == screen.route,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedTextColor = Color.Gray,
                        selectedTextColor = Color.White,
                        selectedIconColor = Color.Black,
                        unselectedIconColor = Color.Gray,
                    ),
                )
            }
        }
    }

    @Composable
    fun NavigationGraph(navController: NavHostController) {
        NavHost(navController, startDestination = Destinations.HomeScreen.route) {
            composable(Destinations.HomeScreen.route) {
                HomeScreen()
            }
            composable(Destinations.Favourite.route) {
                FavouriteScreen()
            }
            composable(Destinations.Notification.route) {
                NotificationScreen()
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
    fun FavouriteScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Magenta)
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
                        text = "Favourite Screen",
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
    fun NotificationScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Blue)
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
                        text = "Notification Screen",
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
}