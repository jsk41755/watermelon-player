package com.devjeong.watermelon_player.android.player.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.devjeong.watermelon_player.android.R

@Composable
fun CurrentTimeTextField(currentTime: String, endTime: String) {
    Text(
        text = currentTime,
        style = TextStyle(
            fontSize = 14.sp,
            lineHeight = 22.sp,
            fontFamily = FontFamily(Font(R.font.pretendard)),
            fontWeight = FontWeight(400),
            color = Color(0xFFFFFFFF),
        )
    )
    Text(
        text = endTime,
        style = TextStyle(
            fontSize = 14.sp,
            lineHeight = 22.sp,
            fontFamily = FontFamily(Font(R.font.pretendard)),
            fontWeight = FontWeight(400),
            color = Color(0xFFFFFFFF),

            textAlign = TextAlign.Right,
        )
    )
}