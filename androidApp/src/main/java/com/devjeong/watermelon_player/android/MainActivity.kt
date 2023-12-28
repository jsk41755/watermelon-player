package com.devjeong.watermelon_player.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devjeong.watermelon_player.Greeting
import com.devjeong.watermelon_player.android.player.presentation.DetailScreen
import com.devjeong.watermelon_player.android.playlist.presentation.PlayListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MusicRoot()
                }
            }
        }
    }
}

@Composable
fun MusicRoot() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lazyColumnSample"
    ) {
        composable(
            "lazyColumnSample"
        ) {
            PlayListScreen(navController)
        }
        composable(
            "detailScreen"
        ) {
            DetailScreen(navController)
        }
    }
}
