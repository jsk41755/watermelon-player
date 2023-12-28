package com.devjeong.watermelon_player.android.playlist.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.devjeong.watermelon_player.playlist.model.Music

@Composable
fun SongItem(navController: NavController, music: Music) {
    Box(
        modifier = Modifier
            .clickable {
                navController.navigate("detailScreen")
            }
            .padding(horizontal = 23.dp)
            .padding(vertical = 12.dp)
            .shadow(
                elevation = 10.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
            .border(
                width = 1.dp,
                color = Color(0x33000000),
                shape = RoundedCornerShape(25.dp)
            )
            .width(344.dp)
            .height(100.dp)
            .background(
                color = Color(0xFF222222),
                shape = RoundedCornerShape(25.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 이미지 박스와 텍스트 컬럼
            ImageAndTextColumn(music)
        }
    }
}

@Composable
fun ImageAndTextColumn(music: Music) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        // 이미지 박스
        Box(
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .background(
                    color = Color(0xFFD9D9D9),
                    shape = RoundedCornerShape(18.dp)
                )
        )
        Spacer(Modifier.width(16.dp)) // 이미지 박스와 텍스트 사이의 간격

        Column {
            // 첫 번째 텍스트
            Text(
                text = music.title,
                modifier = Modifier
                    .widthIn(max = 180.dp)
                    .heightIn(max = 24.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF)
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // 두 번째 텍스트
            Text(
                text = music.artists,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF999999)
                )
            )
        }
    }
}