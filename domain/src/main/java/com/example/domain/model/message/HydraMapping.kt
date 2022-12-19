package com.example.domain.model.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HydraMapping(
    @SerialName("@type")
    val type: String,
    val `property`: String,
    val required: Boolean,
    val variable: String
)