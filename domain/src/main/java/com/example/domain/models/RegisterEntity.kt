package com.example.domain.models

data class RegisterEntity(
    val name: String,
    val lastName: String,
    val email: String,
    val birthDate: String,
    val phoneNumber: String,
    val personalId: String,
    val address: String,
    val password: String,
    val passwordConfirmation: String
)