package com.example.data.mappers.response

import com.example.data.mappers.Mapper
import com.example.data.models.TokenResponseRegistration
import com.example.domain.models.entity.TokenRegistrationResponseEntity
import javax.inject.Inject

open class RegistrationResponseMapper @Inject constructor(private val createdUserMapper: CreatedUserMapper) :
    Mapper<TokenResponseRegistration, TokenRegistrationResponseEntity> {
    override fun mapFrom(model: TokenResponseRegistration): TokenRegistrationResponseEntity {
        return TokenRegistrationResponseEntity(
            createdUserMapper.mapFrom(model.user),
            model.token,
        )
    }
}