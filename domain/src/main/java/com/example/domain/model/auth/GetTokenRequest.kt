package com.example.domain.model.auth

data class GetTokenRequest(
    val username: String,
    val password: String
)