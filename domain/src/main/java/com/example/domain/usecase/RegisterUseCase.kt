package com.example.domain.usecase

import com.example.domain.models.exception.EmailNotValidException
import com.example.domain.repository.Repository
import com.example.domain.models.entity.RegisterEntity
import com.example.domain.models.entity.TokenResponseEntity
import com.example.domain.models.exception.PersonalIdNotValidException
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val repository: Repository) {

    private var errorS: Single<TokenResponseEntity>? = null

    fun registerUserSingle(registerEntityUser: RegisterEntity): Single<TokenResponseEntity> {
        if (!registerEntityUser.email.isValid())
            return Single.error(EmailNotValidException())
        else if (!registerEntityUser.password.isValid { errorS = Single.error(it) })
            return errorS!!
        else if (!registerEntityUser.personalId.isValid())
            return Single.error(PersonalIdNotValidException())
        return repository.registerUserSingle(registerEntityUser)
    }
}