package com.devjeong.watermelon_player.android.player.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devjeong.watermelon_player.android.R
import com.devjeong.watermelon_player.android.player.presentation.components.ContentImage
import com.devjeong.watermelon_player.android.player.presentation.components.CurrentTimeTextField
import com.devjeong.watermelon_player.android.player.presentation.components.CustomProgressBar
import com.devjeong.watermelon_player.android.player.presentation.components.CustomTopAppBar
import com.devjeong.watermelon_player.android.player.presentation.components.LikeButton
import com.devjeong.watermelon_player.android.player.presentation.components.MusicControlButtons
import com.devjeong.watermelon_player.android.player.presentation.components.SongInfo

@Composable
fun DetailScreen(navController: NavController) {
    val isLike = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        CustomTopAppBar(navController)

        ContentImage(imageResId = R.drawable.rectangle_1332)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SongInfo(title = "Trap Future Bass", artist = "RoyaltyFreeMusic")
            LikeButton(isLike = isLike)
        }

        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(Color.LightGray)
                .height(4.dp)
        ) {
            CustomProgressBar(0.5f, "0:33", "03:21")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CurrentTimeTextField("00:32", "03:21")
        }
        MusicControlButtons()
    }
}