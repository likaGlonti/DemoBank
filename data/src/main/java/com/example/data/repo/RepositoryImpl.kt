package com.example.data.repo

import com.example.data.mappers.currency.CurrencyMapper
import com.example.data.mappers.register.RegisterMapper
import com.example.data.network.ApiService
import com.example.domain.repository.Repository
import com.example.domain.models.entity.CurrencyEntity
import com.example.domain.models.entity.RegisterEntity
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val registerMapper: RegisterMapper,
    private val currencyMapper: CurrencyMapper
) :
    Repository {
    override fun getCurrency(): Observable<List<CurrencyEntity>> =
        apiService.getCurrencyTest("CurrencyRates").map {
            it.map { currency ->
                currencyMapper.mapFrom(currency)
            }
        }

    override fun registerUser(userRegister: RegisterEntity): Completable =
        apiService.registerUser(registerMapper.mapFrom(userRegister))

}