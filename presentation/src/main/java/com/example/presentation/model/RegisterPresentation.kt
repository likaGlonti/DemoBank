package com.example.presentation.model

import com.example.domain.models.Email
import com.example.domain.models.Password
import com.example.domain.models.entity.RegisterEntity

class RegisterPresentation(
    private val name: String,
    private val lastName: String,
    private val email: Email,
    private val birthDate: String,
    private val phoneNumber: String,
    private val personalNumber: String,
    private val address: String,
    private val password: Password,
    private val passwordConfirmation: String
) {
    fun createUser(): RegisterEntity {
        return RegisterEntity(
            name,
            lastName,
            email,
            birthDate,
            phoneNumber,
            personalNumber,
            address,
            password,
            passwordConfirmation
        )
    }
}
