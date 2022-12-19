package com.example.data.database

import com.example.data.dao.MessageDao

interface EmailDatabase {
    fun messageDao(): MessageDao

    fun clearData()
}
