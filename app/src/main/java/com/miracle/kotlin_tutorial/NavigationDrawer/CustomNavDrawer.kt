package com.miracle.kotlin_tutorial.NavigationDrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miracle.kotlin_tutorial.R
import com.miracle.kotlin_tutorial.ui.theme.Kotlin_TutorialTheme
import kotlinx.coroutines.launch

class CustomNavDrawer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_TutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CustomNavDrawerUI()
                }
            }
        }
    }

    @OptIn(
        ExperimentalMaterial3Api::class
    )
    @Preview
    @Composable
    fun CustomNavDrawerUI() {
        val navigationState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }

        val items = listOf(
            DrawerItem(
                title = "Home",
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
            ),
            DrawerItem(
                title = "Notification",
                selectedIcon = Icons.Filled.Info,
                unselectedIcon = Icons.Outlined.Info,
                badgeCount = 45
            ),
            DrawerItem(
                title = "Favorites",
                selectedIcon = Icons.Filled.Favorite,
                unselectedIcon = Icons.Outlined.FavoriteBorder,
            ),
        )

        Surface {
            ModalNavigationDrawer(
                drawerContent = {
                    ModalDrawerSheet {
                        Spacer(modifier = Modifier.height(26.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ic_bottom_profile),
                            contentDescription = "",
                            modifier = Modifier
                                .size(80.dp)
                                .fillMaxWidth()
                                .align(CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(26.dp))
                        items.forEachIndexed { index, drawerItem ->
                            NavigationDrawerItem(
                                label = {
                                    Text(text = drawerItem.title)
                                },
                                selected = index == selectedItemIndex,
                                onClick = {
                                    selectedItemIndex = index
                                    scope.launch {
                                        navigationState.close()
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) {
                                            drawerItem.selectedIcon
                                        } else drawerItem.unselectedIcon,
                                        contentDescription = drawerItem.title
                                    )
                                },
                                badge = {
                                    drawerItem.badgeCount?.let {
                                        Text(text = drawerItem.badgeCount.toString())
                                    }
                                },
                                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                            )

                        }
                    }
                },
                drawerState = navigationState,
            ) {
                Scaffold(topBar = {
                    TopAppBar(title = {
                        Text(text = "Navigation Drawer")
                    }, navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                navigationState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    })
                }) {
                    Column {
                        Text(
                            text = "Hii Learner",
                            modifier = Modifier
                                .padding(it)
                                .fillMaxSize(),
                            textAlign = TextAlign.Center
                        )
                    }

                }

            }
        }
    }
}

data class DrawerItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
)

