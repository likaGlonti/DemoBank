package com.example.domain.models.entity

data class TokenRegistrationResponseEntity(
    val user: CreatedUserEntity,
    val token: String,
)
