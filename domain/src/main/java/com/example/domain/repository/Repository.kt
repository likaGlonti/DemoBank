package com.example.domain.repository

import com.example.domain.models.CurrencyEntity
import com.example.domain.models.RegisterEntity
import io.reactivex.Completable
import io.reactivex.Observable

interface Repository {
    fun getCurrency(): Observable<List<CurrencyEntity>>
    fun registerUser(userRegister: RegisterEntity): Completable
}