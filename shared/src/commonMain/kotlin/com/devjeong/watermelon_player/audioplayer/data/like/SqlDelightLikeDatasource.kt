package com.devjeong.watermelon_player.audioplayer.data.like

import com.devjeong.watermelon_player.audioplayer.domain.like.LikeDatasource
import com.devjeong.watermelon_player.audioplayer.domain.like.LikeItem
import com.devjeong.watermelon_player.core.domain.util.CommonFlow
import com.devjeong.watermelon_player.core.domain.util.toCommonFlow
import com.devjeong.watermelon_player.database.LikeDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlDelightLikeDatasource(
    db: LikeDatabase
) : LikeDatasource {

    private val queries = db.likeQueries
    override fun getLikeList(): CommonFlow<List<LikeItem>> {
        return queries
            .getLikeList()
            .asFlow()
            .mapToList()
            .map { like ->
                like.map { it.toLikeItem() }
            }
            .toCommonFlow()
    }

    override suspend fun insertLikeItem(item: LikeItem) {
        queries.insertLikeInstance(
            id = item.id,
            title = item.title,
            timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }

    override suspend fun deleteLikeItem(item: LikeItem) {
        queries.deletelikeInstance(
            title = item.title
        )
    }
}