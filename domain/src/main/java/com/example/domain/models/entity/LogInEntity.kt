package com.example.domain.models.entity

import com.example.domain.models.Email
import com.example.domain.models.Password

data class LogInEntity(
    val email: Email,
    val password: Password,
)
