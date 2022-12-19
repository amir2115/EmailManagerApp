package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.entity.MessageEntity

@Database(
    entities = [
        MessageEntity::class,
    ],
    version = 1
)
abstract class EmailRoomDatabase : RoomDatabase(), EmailDatabase {
    override fun clearData() = clearAllTables()
}