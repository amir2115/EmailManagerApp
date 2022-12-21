package com.example.domain.model.message

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class GetMessageResponse(
    @SerializedName("@context")
    val context: String,
    @SerializedName("@type")
    val type: String,
    val accountId: String,
    val attachments: List<Attachment>,
    val bcc: List<String>,
    val cc: List<String>,
    val createdAt: String,
    val downloadUrl: String,
    val flagged: Boolean,
    val from: From,
    val hasAttachments: Boolean,
    val html: List<String>,
    val id: String,
    val isDeleted: Boolean,
    val msgid: String,
    val retention: Boolean,
    val retentionDate: String,
    val seen: Boolean,
    val size: Int,
    val subject: String,
    val text: String,
    val to: List<To>,
    val updatedAt: String,
    val verifications: List<String>
)