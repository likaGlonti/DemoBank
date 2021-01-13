package com.example.data.mappers.response

import com.example.data.mappers.Mapper
import com.example.data.models.TokenResponse
import com.example.domain.models.entity.TokenResponseEntity
import javax.inject.Inject

open class ResponseMapper @Inject constructor(private val createdUserMapper: CreatedUserMapper) :
    Mapper<TokenResponse, TokenResponseEntity> {
    override fun mapFrom(model: TokenResponse): TokenResponseEntity {
        return TokenResponseEntity(
            createdUserMapper.mapFrom(model.user),
            model.token,
        )
    }
}