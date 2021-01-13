package com.example.data.mappers.response

import com.example.data.mappers.Mapper
import com.example.data.models.CreatedUser
import com.example.domain.models.entity.CreatedUserEntity
import javax.inject.Inject

open class CreatedUserMapper @Inject constructor() : Mapper<CreatedUser, CreatedUserEntity> {
    override fun mapFrom(model: CreatedUser): CreatedUserEntity {
        return CreatedUserEntity(
            model.name,
            model.lastName,
            model.email,
            model.birthDate,
            model.phoneNumber,
            model.address,
            model.personalId,
            model.status,
            model.imageKey,
            model.updatedAt,
            model.createdAt,
            model.id,
        )
    }
}