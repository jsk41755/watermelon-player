package com.devjeong.watermelon_player.android.player.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomProgressBar(progress: Float) {
    val progressBarHeight = 4.dp
    val circleRadius = 8.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(circleRadius * 2)
            .background(Color(0xFF252932))
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val barWidth = size.width
            val barHeight = progressBarHeight.toPx()
            val radius = circleRadius.toPx()

            // 진행 표시줄 그리기
            drawRect(
                color = Color(0xFFCAFB5C),
                size = Size(barWidth * progress, barHeight)
            )

            // 진행 표시줄 끝에 원 그리기
            if (progress > 0) {
                drawCircle(
                    color = Color(0xFFCAFB5C),
                    radius = radius,
                    center = Offset(barWidth * progress, size.height / 2)
                )
            }
        }
    }
}