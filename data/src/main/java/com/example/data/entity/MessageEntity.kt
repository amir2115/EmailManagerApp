package com.example.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MessageEntity(
    @PrimaryKey
    val id: Int,
    val name: String
)
