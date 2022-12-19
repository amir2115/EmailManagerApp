package com.example.domain.model.message

import kotlinx.serialization.Serializable

@Serializable
data class From(
    val address: String,
    val name: String
)