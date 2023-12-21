package com.devjeong.watermelon_player.audioplayer.data.like

import com.devjeong.watermelon_player.audioplayer.domain.like.LikeDatasource
import com.devjeong.watermelon_player.database.LikeDatabase

class SqlDelightLikeDatasource(
    db: LikeDatabase
): LikeDatasource {

    private val queries = db.likeQueries
}