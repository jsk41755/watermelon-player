package com.devjeong.watermelon_player.android.playlist.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.devjeong.watermelon_player.android.playlist.presentation.components.SongItem

@Composable
fun PlayListScreen(navController: NavController) {
    val musicListViewModel: AndroidMusicListViewModel = viewModel()
    val musicList by musicListViewModel.musicListViewModel.musicList.collectAsState()

    LazyColumn {
        items(items = musicList) { music ->
            SongItem(navController = navController, music = music)
        }
    }
}