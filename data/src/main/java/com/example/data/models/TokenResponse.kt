package com.example.data.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(
    @Contextual val user: CreatedUser,
    val token: String,
)