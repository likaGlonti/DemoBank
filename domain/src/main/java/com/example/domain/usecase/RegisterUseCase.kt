package com.example.domain.usecase

import com.example.domain.models.exception.EmailNotValidException
import com.example.domain.repository.Repository
import com.example.domain.models.entity.RegisterEntity
import com.example.domain.models.exception.PersonalIdNotValidException
import io.reactivex.Completable
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val repository: Repository) {

    private var error: Completable? = null

    fun registerUser(registerEntityUser: RegisterEntity): Completable {
        if (!registerEntityUser.email.isValid())
            return Completable.error(EmailNotValidException())
        else if (!registerEntityUser.password.isValid { error = Completable.error(it) })
            return error!!
        else if (!registerEntityUser.personalId.isValid())
            return Completable.error(PersonalIdNotValidException())
        return repository.registerUser(registerEntityUser)
    }
}