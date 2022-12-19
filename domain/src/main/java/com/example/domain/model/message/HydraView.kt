package com.example.domain.model.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HydraView(
    @SerialName("@id")
    val id: String,
    @SerialName("@type")
    val type: String,
    @SerialName("hydra:first")
    val first: String,
    @SerialName("hydra:last")
    val last: String,
    @SerialName("hydra:next")
    val next: String,
    @SerialName("hydra:previous")
    val previous: String
)