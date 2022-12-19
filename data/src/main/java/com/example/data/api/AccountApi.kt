package com.example.data.api

import com.example.domain.model.account.AddAccountRequest
import com.example.domain.model.account.CreateAccountResponse
import retrofit2.Response
import retrofit2.http.*

interface AccountApi {
    @POST("/accounts")
    suspend fun addAccount(
        @Body addAccountRequest: AddAccountRequest
    ): Response<Unit>

    @DELETE("/accounts/{id}")
    suspend fun deleteAccount(
        @Path("id") id: String
    ): Response<Unit>

    @GET("/me")
    suspend fun getAccount(): Response<CreateAccountResponse>
}