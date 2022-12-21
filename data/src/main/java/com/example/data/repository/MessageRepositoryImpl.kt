package com.example.data.repository

import com.example.data.api.MessageApi
import com.example.data.bodyOrThrow
import com.example.data.mock.mockMessageData
import com.example.data.mock.mockMessagesData
import com.example.domain.model.message.GetMessageResponse
import com.example.domain.model.message.GetMessagesResponse
import com.example.domain.repository.MessageRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MessageRepositoryImpl @Inject constructor(
    private val messageApi: MessageApi
) : MessageRepository {

    override suspend fun getMessages(): GetMessagesResponse {
//        return messageApi.getMessages().bodyOrThrow()
        return mockMessagesData
    }

    override suspend fun getMessage(id: String): GetMessageResponse {
//        return messageApi.getMessage(id).bodyOrThrow()
        return mockMessageData
    }

    override suspend fun deleteMessage(id: String) {
        return messageApi.deleteMessage(id).bodyOrThrow()
    }
}