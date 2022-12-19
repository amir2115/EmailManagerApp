package com.example.domain.repository

import com.example.domain.model.auth.GetTokenRequest
import com.example.domain.model.auth.GetTokenResponse

interface AuthRepository {
    suspend fun getToken(getTokenRequest: GetTokenRequest): GetTokenResponse
}