package com.example.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Register(
    val name: String,
    @SerialName("lastname")
    val lastName: String,
    val email: String,
    @SerialName("birth_date") val birthDate: String,
    @SerialName("phone_number") val phoneNumber: String,
    @SerialName("personal_number") val personalId: String,
    val address: String,
    val password: String,
    @SerialName("password_confirmation") val passwordConfirmation: String,
)