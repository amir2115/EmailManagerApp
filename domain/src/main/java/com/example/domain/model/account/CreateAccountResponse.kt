package com.example.domain.model.account

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateAccountResponse(
    @SerialName("@context")
    val context: String,
    @SerialName("@type")
    val type: String,
    val address: String,
    val createdAt: String,
    val id: String,
    val isDeleted: Boolean,
    val isDisabled: Boolean,
    val quota: Int,
    val updatedAt: String,
    val used: Int
)