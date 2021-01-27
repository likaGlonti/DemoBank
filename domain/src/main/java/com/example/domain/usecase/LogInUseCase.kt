package com.example.domain.usecase

import com.example.domain.models.entity.LogInEntity
import com.example.domain.models.entity.TokenRegistrationResponseEntity
import com.example.domain.models.entity.TokenResponseLoginEntity
import com.example.domain.models.exception.EmailNotValidException
import com.example.domain.repository.Repository
import io.reactivex.Single
import javax.inject.Inject

class LogInUseCase @Inject constructor(private val repository: Repository) {

    private var error: Single<TokenResponseLoginEntity>? = null

    fun logIn(logIn: LogInEntity): Single<TokenResponseLoginEntity> {
        if (!logIn.email.isValid())
            return Single.error(EmailNotValidException())
        else if (!logIn.password.isValid { error = Single.error(it) })
            return error!!
        return repository.logIn(logIn)
    }
}