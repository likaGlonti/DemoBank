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

    private var error: Completable? = null
    private var errorS: Single<TokenResponseEntity>? = null

    fun registerUser(registerEntityUser: RegisterEntity): Completable {
        if (!registerEntityUser.email.isValid())
            return Completable.error(EmailNotValidException())
        else if (!registerEntityUser.password.isValid { error = Completable.error(it) })
            return error!!
        else if (!registerEntityUser.personalId.isValid())
            return Completable.error(PersonalIdNotValidException())
        return repository.registerUser(registerEntityUser)
    }

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