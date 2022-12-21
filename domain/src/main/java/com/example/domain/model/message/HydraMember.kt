package com.example.domain.model.message

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class HydraMember(
    @SerializedName("@context")
    val context: String,
    @SerializedName("@type")
    val type: String,
    val accountId: String,
    val createdAt: String,
    val downloadUrl: String,
    val from: From,
    val hasAttachments: Boolean,
    val id: String,
    val intro: String,
    val isDeleted: Boolean,
    val msgid: String,
    val seen: Boolean,
    val size: Int,
    val subject: String,
    val to: List<To>,
    val updatedAt: String
)