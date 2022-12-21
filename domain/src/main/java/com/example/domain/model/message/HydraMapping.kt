package com.example.domain.model.message

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class HydraMapping(
    @SerializedName("@type")
    val type: String,
    val `property`: String,
    val required: Boolean,
    val variable: String
)