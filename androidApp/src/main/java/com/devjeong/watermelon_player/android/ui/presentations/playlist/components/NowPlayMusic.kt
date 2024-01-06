package com.devjeong.watermelon_player.android.ui.presentations.playlist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NowPlayMusic(backgroundColor: Color) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0x33000000),
                shape = RoundedCornerShape(0.dp, 0.dp, 50.dp, 50.dp)
            )
            .width(390.dp)
            .height(310.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(0.dp, 0.dp, 50.dp, 50.dp)
            )
    ) {
        PlayListTopAppBar(backgroundColor)
    }
}