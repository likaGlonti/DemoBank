package com.example.data.mappers.response

import com.example.data.mappers.Mapper
import com.example.data.models.LogIn
import com.example.domain.models.entity.LogInEntity
import javax.inject.Inject

open class LogInMapper @Inject constructor() : Mapper<LogInEntity, LogIn> {
    override fun mapFrom(model: LogInEntity): LogIn {
        return LogIn(
            model.email.toString(),
            model.password.toString(),
        )
    }
}