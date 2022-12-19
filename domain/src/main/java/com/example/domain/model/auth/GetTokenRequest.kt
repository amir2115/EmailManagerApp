package com.example.domain.model.auth

data class GetTokenRequest(
    val address: String,
    val password: String
)