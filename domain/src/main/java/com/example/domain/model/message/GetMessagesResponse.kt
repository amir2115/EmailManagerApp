package com.example.domain.model.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetMessagesResponse(
    @SerialName("hydra:member")
    val member: List<HydraMember>,
    @SerialName("hydra:search")
    val search: HydraSearch?,
    @SerialName("hydra:totalItems")
    val totalItems: Int,
    @SerialName("hydra:view")
    val view: HydraView?
)