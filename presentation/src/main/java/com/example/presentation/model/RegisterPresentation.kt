package com.example.presentation.model

import com.example.domain.models.RegisterEntity

class RegisterPresentation(
    private val name: String,
    private val lastName: String,
    private val email: String,
    private val birthDate: String,
    private val phoneNumber: String,
    private val personalNumber: String,
    private val address: String,
    private val password: String,
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
