package com.example.presentation.model

import com.example.domain.models.Email
import com.example.domain.models.Password
import com.example.domain.models.entity.LogInEntity

class LogInPresentation (
    private val email: Email,
    private val password: Password,
) {
    fun getLogIn(): LogInEntity {
        return LogInEntity(
            email,
            password,
        )
    }
}