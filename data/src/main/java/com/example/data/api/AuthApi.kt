package com.example.data.api

import com.example.domain.model.auth.GetTokenRequest
import com.example.domain.model.auth.GetTokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("/token")
    suspend fun getToken(
        @Body getTokenRequest: GetTokenRequest
    ): Response<GetTokenResponse>
}