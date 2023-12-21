package com.devjeong.watermelon_player.audioplayer.domain.like

import com.devjeong.watermelon_player.core.domain.util.CommonFlow

interface LikeDatasource {

    fun getLikeList(): CommonFlow<List<LikeItem>>

    suspend fun insertLikeItem(item: LikeItem)

    suspend fun deleteLikeItem(item: LikeItem)
}