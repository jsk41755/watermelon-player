package com.devjeong.watermelon_player.android.ui.presentations.like

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import com.devjeong.watermelon_player.android.ui.presentations.playlist.PlayListViewModel
import com.devjeong.watermelon_player.android.ui.presentations.playlist.components.NowPlayMusic
import com.devjeong.watermelon_player.android.ui.presentations.playlist.components.SongItem

@Composable
fun LikeScreen(navController: NavController, playListViewModel: PlayListViewModel) {
    val backgroundColor = remember {
        Color(0xFFDBDBDB)
    }

    val context = LocalContext.current
    val window = (context as Activity).window

    SideEffect {
        window.statusBarColor = backgroundColor.toArgb()
        WindowCompat.getInsetsController(window, window.decorView)
            .isAppearanceLightStatusBars = true
    }

    val likedMusicList by playListViewModel.musicListViewModel.likedMusicList.collectAsState()

    Column {
        NowPlayMusic(backgroundColor)

        LazyColumn {
            items(items = likedMusicList.sortedBy { it.id }) { music ->
                SongItem(navController = navController, music = music)
            }
        }
    }
}