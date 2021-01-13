package com.example.domain.models.entity

data class TokenResponseEntity(val user: CreatedUserEntity,
                               val token: String,
)
