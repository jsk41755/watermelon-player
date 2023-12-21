package com.devjeong.watermelon_player.audioplayer.data.like

import com.devjeong.watermelon_player.audioplayer.domain.like.LikeItem
import database.LikeEntity

fun LikeEntity.toLikeItem(): LikeItem {
    return LikeItem(
        id = id,
        title
    )
}