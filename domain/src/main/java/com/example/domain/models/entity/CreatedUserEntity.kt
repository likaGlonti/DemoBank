package com.example.domain.models.entity

data class CreatedUserEntity(
    val name: String,
    val lastName: String,
    val email: String,
    val birthDate: String,
    val phoneNumber: String,
    val address: String,
    val personalId: String,
    val status: String,
    val imageKey: Int,
    val updatedAt: String,
    val createdAt: String,
    val id: Int,
)
