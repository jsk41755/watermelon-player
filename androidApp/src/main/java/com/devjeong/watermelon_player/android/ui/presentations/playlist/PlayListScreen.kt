package com.devjeong.watermelon_player.android.ui.presentations.playlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.devjeong.watermelon_player.android.ui.presentations.playlist.components.SongItem
import com.devjeong.watermelon_player.presentations.MusicListViewModel

@Composable
fun PlayListScreen(navController: NavController, playListViewModel: PlayListViewModel) {
    val musicList by playListViewModel.musicListViewModel.musicList.collectAsState()

    LazyColumn {
        items(items = musicList) { music ->
            SongItem(navController = navController, music = music)
        }
    }
}