package com.devjeong.watermelon_player.android.ui.presentations.player.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


//@Composable
//fun DurationView(currentPosition: Long, totalDuration: Long) {
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//    ) {
//
//        Text(
//            text = (currentPosition.longValue).convertToText(),
//            modifier = Modifier
//                .weight(1f)
//                .padding(8.dp),
//            color = Color.Black,
//            style = TextStyle(fontWeight = FontWeight.Bold)
//        )
//
//        val remainTime = totalDuration.longValue - currentPosition.longValue
//        Text(
//            text = if (remainTime >= 0) remainTime.convertToText() else "",
//            modifier = Modifier
//                .padding(8.dp),
//            color = Color.Black,
//            style = TextStyle(fontWeight = FontWeight.Bold)
//        )
//    }
//
//}