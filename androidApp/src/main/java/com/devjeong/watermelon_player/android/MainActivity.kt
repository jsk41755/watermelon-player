package com.devjeong.watermelon_player.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devjeong.watermelon_player.android.player.presentation.PlayerScreen
import com.devjeong.watermelon_player.android.playlist.presentation.AndroidMusicListViewModel
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
    val musicListViewModel: AndroidMusicListViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "lazyColumnSample"
    ) {
        composable(
            "lazyColumnSample"
        ) {
            PlayListScreen(navController, musicListViewModel)
        }
        composable(
            "PlayerScreen/{musicId}",
            arguments = listOf(navArgument("musicId") { type = NavType.IntType })
        ) { backStackEntry ->
            val musicId = backStackEntry.arguments?.getInt("musicId") ?: -1
            PlayerScreen(navController, musicListViewModel, musicId)
        }
    }
}
