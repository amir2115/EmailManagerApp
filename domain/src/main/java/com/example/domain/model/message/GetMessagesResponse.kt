package com.example.domain.model.message

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class GetMessagesResponse(
    @SerializedName("hydra:member")
    val member: List<HydraMember>,
    @SerializedName("hydra:search")
    val search: HydraSearch?,
    @SerializedName("hydra:totalItems")
    val totalItems: Int,
    @SerializedName("hydra:view")
    val view: HydraView?
)