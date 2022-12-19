package com.example.data.repository

import com.example.data.api.AuthApi
import com.example.data.bodyOrThrow
import com.example.domain.model.auth.GetTokenRequest
import com.example.domain.model.auth.GetTokenResponse
import com.example.domain.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {

    override suspend fun getToken(getTokenRequest: GetTokenRequest): GetTokenResponse {
        return authApi.getToken(getTokenRequest).bodyOrThrow()
    }

}