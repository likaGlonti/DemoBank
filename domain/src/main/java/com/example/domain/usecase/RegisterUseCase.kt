package com.example.domain.usecase

import com.example.domain.repository.Repository
import com.example.domain.models.RegisterEntity
import io.reactivex.Completable
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val repository: Repository) {

    fun registerUser(registerEntityUser: RegisterEntity): Completable {
        return repository.registerUser(registerEntityUser)
    }
}