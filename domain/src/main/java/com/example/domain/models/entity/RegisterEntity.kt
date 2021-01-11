package com.example.domain.models.entity

import com.example.domain.models.Email
import com.example.domain.models.Password
import com.example.domain.models.PersonalId

data class RegisterEntity(
    val name: String,
    val lastName: String,
    val email: Email,
    val birthDate: String,
    val phoneNumber: String,
    val personalId: PersonalId,
    val address: String,
    val password: Password,
    val passwordConfirmation: String
)