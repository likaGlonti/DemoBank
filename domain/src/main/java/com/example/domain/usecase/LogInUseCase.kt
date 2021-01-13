package com.example.domain.usecase

import com.example.domain.models.entity.LogInEntity
import com.example.domain.models.exception.EmailNotValidException
import com.example.domain.repository.Repository
import io.reactivex.Completable
import javax.inject.Inject

class LogInUseCase @Inject constructor(private val repository: Repository) {

    private var error: Completable? = null

    fun logIn(logIn: LogInEntity): Completable {
        if (!logIn.email.isValid())
            return Completable.error(EmailNotValidException())
        else if (!logIn.password.isValid { error = Completable.error(it) })
            return error!!
        return repository.logIn(logIn)
    }
}