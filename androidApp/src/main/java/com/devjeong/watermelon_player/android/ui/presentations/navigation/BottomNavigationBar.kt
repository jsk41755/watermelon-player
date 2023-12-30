package com.devjeong.watermelon_player.android.ui.presentations.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.devjeong.watermelon_player.android.R

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        "home" to R.drawable.nav_home,
        "playlist" to R.drawable.nav_playlist,
        "search" to R.drawable.nav_search,
        "like" to R.drawable.nav_like
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Surface(
        modifier = Modifier
            .height(96.dp),
        color = Color.Red,
        shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
        shadowElevation = 10.dp,
    ) {
        BottomAppBar(
            modifier = Modifier
                .height(96.dp),
            containerColor = Color(0xFF444444)
        ) {
            items.forEach { (route, icon) ->
                val isSelected = currentRoute == route
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = route,
                            tint = if (isSelected) Color(0xFFCAFB5C) else Color(0xFF999999)
                        )
                    },
                    selected = isSelected,
                    onClick = {
                        if (currentRoute != route) {
                            navController.navigate(route) {
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color(0xFF444444)
                    )
                )
            }
        }
    }
}

