package com.devjeong.watermelon_player.android.player.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devjeong.watermelon_player.android.R

@Composable
fun LikeButton(isLike: MutableState<Boolean>) {
    IconButton(onClick = { isLike.value = !isLike.value }) {
        Image(
            painter = if (!isLike.value) painterResource(id = R.drawable.un_active_like)
            else painterResource(id = R.drawable.active_like),
            contentDescription = "Like Button",
            modifier = Modifier
                .padding(0.dp)
                .width(28.dp)
                .height(28.dp)
        )
    }
}