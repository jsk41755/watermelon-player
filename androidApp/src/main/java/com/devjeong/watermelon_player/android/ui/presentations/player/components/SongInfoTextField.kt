package com.devjeong.watermelon_player.android.ui.presentations.player.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.devjeong.watermelon_player.android.R


@Composable
fun SongInfo(title: String, artist: String) {
    Column {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontFamily = FontFamily(Font(R.font.pretendard)),
                fontWeight = FontWeight(700),
                color = Color.White
            )
        )

        Text(
            text = artist,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.pretendard)),
                fontWeight = FontWeight(400),
                color = Color.Gray,
            )
        )
    }
}