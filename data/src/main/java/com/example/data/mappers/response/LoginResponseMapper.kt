package com.example.data.mappers.response

import com.example.data.mappers.Mapper
import com.example.data.models.TokenResponseLogIn
import com.example.domain.models.entity.TokenResponseLoginEntity
import javax.inject.Inject

class LoginResponseMapper @Inject constructor():Mapper<TokenResponseLogIn, TokenResponseLoginEntity> {
    override fun mapFrom(model: TokenResponseLogIn): TokenResponseLoginEntity {
        return TokenResponseLoginEntity(model.token)
    }
}