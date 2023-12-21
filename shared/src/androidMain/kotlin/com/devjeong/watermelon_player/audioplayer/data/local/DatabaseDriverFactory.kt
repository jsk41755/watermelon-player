package com.devjeong.watermelon_player.audioplayer.data.local

import android.content.Context
import com.devjeong.watermelon_player.database.LikeDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(
    private val context: Context
) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(LikeDatabase.Schema, context, "like.db")
    }
}