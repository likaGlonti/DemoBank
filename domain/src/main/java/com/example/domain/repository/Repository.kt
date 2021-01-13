package com.example.domain.repository

import com.example.domain.models.entity.CurrencyEntity
import com.example.domain.models.entity.LogInEntity
import com.example.domain.models.entity.RegisterEntity
import com.example.domain.models.entity.TokenResponseEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface Repository {
    fun getCurrency(): Observable<List<CurrencyEntity>>
    fun registerUser(userRegister: RegisterEntity): Completable
    fun registerUserSingle(user: RegisterEntity): Single<TokenResponseEntity>
    fun logIn(user:LogInEntity):Completable
}