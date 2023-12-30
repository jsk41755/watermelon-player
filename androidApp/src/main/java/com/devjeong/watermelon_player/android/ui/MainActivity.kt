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
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devjeong.watermelon_player.android.MyApplicationTheme
import com.devjeong.watermelon_player.android.ui.presentations.home.HomeScreen
import com.devjeong.watermelon_player.android.ui.presentations.like.LikeScreen
import com.devjeong.watermelon_player.android.ui.presentations.navigation.BottomNavigationBar
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

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "playlist",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen() }
            composable("playlist") { PlayListScreen(navController, playListViewModel) }
            composable("search") { SearchScreen() }
            composable("like") { LikeScreen() }
        }
    }
}
