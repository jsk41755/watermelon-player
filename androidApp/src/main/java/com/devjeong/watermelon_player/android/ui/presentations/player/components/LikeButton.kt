package com.devjeong.watermelon_player.android.ui.presentations.player.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devjeong.watermelon_player.android.R

@Composable
fun LikeButton(initialIsLiked: Boolean, onClick: (Boolean) -> Unit) {
    val isLiked = remember { mutableStateOf(initialIsLiked) }

    Log.d("initialIsLiked", initialIsLiked.toString())
    IconButton(onClick = {
        isLiked.value = !isLiked.value
        onClick(isLiked.value)
    }) {
        val imageResId = if (initialIsLiked) R.drawable.active_like else R.drawable.un_active_like
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "Like Button",
            modifier = Modifier
                .padding(0.dp)
                .width(28.dp)
                .height(28.dp)
        )
    }
}
