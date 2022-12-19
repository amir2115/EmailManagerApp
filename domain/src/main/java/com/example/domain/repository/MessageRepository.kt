package com.example.domain.repository

import com.example.domain.model.message.GetMessageResponse
import com.example.domain.model.message.GetMessagesResponse

interface MessageRepository {
    suspend fun getMessages(): GetMessagesResponse
    suspend fun getMessage(id: String): GetMessageResponse
    suspend fun deleteMessage(id: String)
}