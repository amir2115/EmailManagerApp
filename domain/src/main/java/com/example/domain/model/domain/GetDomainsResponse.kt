package com.example.domain.model.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetDomainsResponse(
    @SerialName("hydra:member")
    val member: List<HydraMember>,
)