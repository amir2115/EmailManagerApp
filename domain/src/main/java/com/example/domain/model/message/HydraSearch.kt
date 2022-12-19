package com.example.domain.model.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HydraSearch(
    @SerialName("@type")
    val type: String,
    @SerialName("hydra:mapping")
    val mapping: List<HydraMapping>,
    @SerialName("hydra:template")
    val template: String,
    @SerialName("hydra:variableRepresentation")
    val variableRepresentation: String
)