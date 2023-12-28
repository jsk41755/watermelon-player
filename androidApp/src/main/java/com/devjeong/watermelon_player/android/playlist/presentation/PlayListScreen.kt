package com.devjeong.watermelon_player.android.playlist.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.devjeong.watermelon_player.android.playlist.presentation.components.SongItem

@Composable
fun PlayListScreen(navController: NavController) {
    val dataList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    LazyColumn {
        items(items = dataList) { item ->
            SongItem(navController = navController, item = item)
        }
    }
}