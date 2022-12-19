package com.example.domain.model.message

import kotlinx.serialization.Serializable

@Serializable
data class To(
    val address: String,
    val name: String
)