package com.example.domain.model.message

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class HydraView(
    @SerializedName("@id")
    val id: String,
    @SerializedName("@type")
    val type: String,
    @SerializedName("hydra:first")
    val first: String,
    @SerializedName("hydra:last")
    val last: String,
    @SerializedName("hydra:next")
    val next: String,
    @SerializedName("hydra:previous")
    val previous: String
)