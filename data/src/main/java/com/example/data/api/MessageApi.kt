package com.example.data.api

import com.example.domain.model.message.GetMessageResponse
import com.example.domain.model.message.GetMessagesResponse
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface MessageApi {
    @GET("/messages")
    suspend fun getMessages(): Response<GetMessagesResponse>

    @DELETE("/messages/{id}")
    suspend fun deleteMessage(
        @Path("id") id: String
    ): Response<Unit>

    @GET("/messages/{id}")
    suspend fun getMessage(
        @Path("id") id: String
    ): Response<GetMessageResponse>
}