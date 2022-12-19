package com.example.domain.model.message

import kotlinx.serialization.Serializable

@Serializable
data class Attachment(
    val contentType: String,
    val disposition: String,
    val downloadUrl: String,
    val filename: String,
    val id: String,
    val related: Boolean,
    val size: Int,
    val transferEncoding: String
)