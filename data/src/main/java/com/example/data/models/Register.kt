package com.example.data.models

import com.google.gson.annotations.SerializedName

class Register(
    val name: String,
    @SerializedName("lastname")
    val lastName: String,
    val email: String,
    @SerializedName("birth_date") val birthDate: String,
    @SerializedName("phone_number") val phoneNumber: String,
    @SerializedName("personal_number") val personalId: String,
    val address: String,
    val password: String,
    @SerializedName("password_confirmation") val passwordConfirmation: String
)