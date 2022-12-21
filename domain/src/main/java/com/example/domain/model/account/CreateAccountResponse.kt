package com.example.domain.model.account

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CreateAccountResponse(
    @SerializedName("@context")
    val context: String,
    @SerializedName("@type")
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