package com.example.data.models

import kotlinx.serialization.Serializable


@Serializable
data class LogIn(
    val email: String,
    val password: String,
)
