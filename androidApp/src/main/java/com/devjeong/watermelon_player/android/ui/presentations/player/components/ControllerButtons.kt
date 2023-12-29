package com.devjeong.watermelon_player.android.ui.presentations.player.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devjeong.watermelon_player.android.R

@Composable
fun MusicControlButtons() {
    val isPlaying = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 반복 재생 버튼
        IconButton(onClick = { /* 반복 재생 동작 */ }) {
            Icon(
                painter = painterResource(id = R.drawable.repeat),
                contentDescription = "반복 재생",
                tint = Color(0xFF999999)
            )
        }

        // 이전 노래 버튼
        IconButton(onClick = { /* 이전 노래 동작 */ }) {
            Icon(
                painter = painterResource(id = R.drawable.skip_previous),
                contentDescription = "이전 노래",
                tint = Color.White
            )
        }

        Box(
            modifier = Modifier
                .border(
                    width = 1.dp, color = Color(0x33000000),
                    shape = RoundedCornerShape(size = 26.dp)
                )
                .width(80.dp)
                .height(80.dp)
                .background(
                    color = Color(0xFF222222),
                    shape = RoundedCornerShape(size = 26.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = { isPlaying.value = !isPlaying.value }) {
                Icon(
                    painter =
                    if (isPlaying.value)
                        painterResource(id = R.drawable.pause)
                    else
                        painterResource(id = R.drawable.play),
                    contentDescription = if (isPlaying.value) "일시정지" else "재생",
                    tint = Color.White
                )
            }
        }

        // 다음 노래 버튼
        IconButton(onClick = { /* 다음 노래 동작 */ }) {
            Icon(
                painter = painterResource(id = R.drawable.skip_next),
                contentDescription = "다음 노래",
                tint = Color.White
            )
        }

        // 셔플 버튼
        IconButton(onClick = { /* 셔플 동작 */ }) {
            Icon(
                painter = painterResource(id = R.drawable.shuffle),
                contentDescription = "셔플",
                tint = Color(0xFF999999)
            )
        }
    }
}