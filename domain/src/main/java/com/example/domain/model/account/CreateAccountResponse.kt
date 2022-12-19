package com.example.domain.model.account

data class CreateAccountResponse(
    val address: String,
    val createdAt: String,
    val id: String,
    val isDeleted: Boolean,
    val isDisabled: Boolean,
    val quota: Int,
    val retentionAt: String,
    val updatedAt: String,
    val used: Int
)