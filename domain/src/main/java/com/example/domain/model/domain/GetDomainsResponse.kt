package com.example.domain.model.domain

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class GetDomainsResponse(
    @SerializedName("hydra:member")
    val member: List<HydraMember>,
)