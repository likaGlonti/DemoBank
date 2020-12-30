package com.example.data.mappers.register

import com.example.data.mappers.Mapper
import com.example.data.models.Register
import com.example.domain.models.entity.RegisterEntity
import javax.inject.Inject

open class RegisterMapper @Inject constructor(): Mapper<RegisterEntity, Register> {
    override fun mapFrom(model: RegisterEntity): Register {
        return Register(
            model.name,
            model.lastName,
            model.email.toString(),
            model.birthDate,
            model.phoneNumber,
            model.personalId,
            model.address,
            model.password.toString(),
            model.passwordConfirmation
        )
    }
}