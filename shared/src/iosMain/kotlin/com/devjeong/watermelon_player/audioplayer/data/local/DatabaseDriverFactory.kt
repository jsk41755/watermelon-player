package com.devjeong.watermelon_player.audioplayer.data.local

import com.devjeong.watermelon_player.database.LikeDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(LikeDatabase.Schema, "like.db")
    }
}