package com.example.domain.repository

import com.example.domain.models.entity.*
import io.reactivex.Observable
import io.reactivex.Single

interface Repository {
    fun getCurrency(): Observable<List<CurrencyEntity>>
    fun registerUserSingle(user: RegisterEntity): Single<TokenRegistrationResponseEntity>
    fun logIn(user:LogInEntity):Single<TokenResponseLoginEntity>
}