package com.example.domain.repository

import com.example.domain.models.entity.CurrencyEntity
import com.example.domain.models.entity.RegisterEntity
import io.reactivex.Completable
import io.reactivex.Observable

interface Repository {
    fun getCurrency(): Observable<List<CurrencyEntity>>
    fun registerUser(userRegister: RegisterEntity): Completable
}