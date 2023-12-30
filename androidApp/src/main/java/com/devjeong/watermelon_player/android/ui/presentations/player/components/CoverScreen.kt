package com.devjeong.watermelon_player.android.ui.presentations.player.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ContentImage(imageResId: String) {
    GlideImage(
        model = imageResId,
        contentDescription = "Cover Screen",
        modifier = Modifier
            .shadow(
                elevation = 10.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
            .padding(top = 24.dp)
            .clip(shape = RoundedCornerShape(size = 50.dp))
            .width(344.dp)
            .height(344.dp)
    )
}