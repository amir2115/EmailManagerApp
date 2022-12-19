package com.example.domain.model.domain

import kotlinx.serialization.Serializable

@Serializable
data class HydraMember(
    val domain: String,
    val isActive: Boolean,
)