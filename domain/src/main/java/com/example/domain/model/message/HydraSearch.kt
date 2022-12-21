package com.example.domain.model.message

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class HydraSearch(
    @SerializedName("@type")
    val type: String,
    @SerializedName("hydra:mapping")
    val mapping: List<HydraMapping>,
    @SerializedName("hydra:template")
    val template: String,
    @SerializedName("hydra:variableRepresentation")
    val variableRepresentation: String
)