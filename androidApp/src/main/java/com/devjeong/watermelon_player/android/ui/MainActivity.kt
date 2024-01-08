package com.devjeong.watermelon_player.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devjeong.watermelon_player.android.MyApplicationTheme
import com.devjeong.watermelon_player.android.ui.presentations.home.HomeScreen
import com.devjeong.watermelon_player.android.ui.presentations.like.LikeScreen
import com.devjeong.watermelon_player.android.ui.presentations.navigation.BottomNavigationBar
import com.devjeong.watermelon_player.android.ui.presentations.player.PlayViewModel
import com.devjeong.watermelon_player.android.ui.presentations.player.PlayerScreen
import com.devjeong.watermelon_player.android.ui.presentations.playlist.PlayListScreen
import com.devjeong.watermelon_player.android.ui.presentations.playlist.PlayListViewModel
import com.devjeong.watermelon_player.android.ui.presentations.search.SearchScreen
import org.koin.androidx.compose.get

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicRoot() {
    val navController = rememberNavController()
    val playListViewModel: PlayListViewModel = get()
    val playViewModel: PlayViewModel = get()

    val musicList by playListViewModel.musicListViewModel.musicList.collectAsState()

    playViewModel.apply {
        initialize(musicList)
    }

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != "player/{musicId}") {
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "playlist",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen() }
            composable("playlist") { PlayListScreen(navController, playListViewModel) }
            composable("search") { SearchScreen() }
            composable("like") { LikeScreen(navController, playListViewModel) }
            composable(
                route = "player/{musicId}",
                arguments = listOf(navArgument("musicId") { type = NavType.IntType })
            ) { backStackEntry ->
                val musicId = backStackEntry.arguments?.getInt("musicId") ?: -1
                PlayerScreen(navController, playListViewModel, musicId, playViewModel)
            }
        }
    }
}
