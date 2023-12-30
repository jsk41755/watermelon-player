package com.devjeong.watermelon_player.android.ui.presentations.like

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.devjeong.watermelon_player.android.ui.presentations.playlist.PlayListViewModel
import com.devjeong.watermelon_player.android.ui.presentations.playlist.components.SongItem

@Composable
fun LikeScreen(navController: NavController, playListViewModel: PlayListViewModel) {
    val likedMusicList by playListViewModel.musicListViewModel.likedMusicList.collectAsState()

    LazyColumn {
        items(items = likedMusicList.sortedBy { it.id }) { music ->
            SongItem(navController = navController, music = music)
        }
    }
}