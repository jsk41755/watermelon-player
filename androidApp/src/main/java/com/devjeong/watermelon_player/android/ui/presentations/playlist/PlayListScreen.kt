package com.devjeong.watermelon_player.android.ui.presentations.playlist

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
import androidx.navigation.NavController
import com.devjeong.watermelon_player.android.ui.presentations.playlist.components.NowPlayMusic
import com.devjeong.watermelon_player.android.ui.presentations.playlist.components.SongItem
import kotlin.random.Random

@Composable
fun PlayListScreen(navController: NavController, playListViewModel: PlayListViewModel) {
    val backgroundColor = remember {
        val colors = listOf(0xFFCAFB5C, 0xFF185ADB, 0xFFFF96AD)
        Color(colors[Random.nextInt(colors.size)])
    }

    val context = LocalContext.current
    val window = (context as Activity).window

    SideEffect {
        window.statusBarColor = backgroundColor.toArgb()
    }

    val musicList by playListViewModel.musicListViewModel.musicList.collectAsState()

    Column {
        NowPlayMusic(backgroundColor)

        LazyColumn {
            items(items = musicList.sortedBy { it.id }) { music ->
                SongItem(navController = navController, music = music)
            }
        }
    }
}
