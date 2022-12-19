package com.example.domain.model.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HydraMember(
    @SerialName("@context")
    val context: String,
    @SerialName("@type")
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