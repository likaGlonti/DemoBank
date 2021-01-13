package com.example.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreatedUser(
    val name: String,
    @SerialName("lastname") val lastName: String,
    val email: String,
    @SerialName("birth_date") val birthDate: String,
    @SerialName("phone_number") val phoneNumber: String,
    val address: String,
    @SerialName("personal_number") val personalId: String,
    val status: String,
    @SerialName("image_key") val imageKey: Int,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("created_at") val createdAt: String,
    val id: Int,
)
