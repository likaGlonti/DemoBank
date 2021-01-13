package com.example.data.repo

import com.example.data.mappers.currency.CurrencyMapper
import com.example.data.mappers.authorize.RegisterMapper
import com.example.data.mappers.response.LogInMapper
import com.example.data.mappers.response.ResponseMapper
import com.example.data.network.ApiService
import com.example.domain.repository.Repository
import com.example.domain.models.entity.CurrencyEntity
import com.example.domain.models.entity.LogInEntity
import com.example.domain.models.entity.RegisterEntity
import com.example.domain.models.entity.TokenResponseEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val registerMapper: RegisterMapper,
    private val currencyMapper: CurrencyMapper,
    private val responseMapper: ResponseMapper,
    private val logInMapper: LogInMapper,
) :
    Repository {
    override fun getCurrency(): Observable<List<CurrencyEntity>> =
        apiService.getCurrencyTest("currency-rates").map {
            it.map { currency ->
                currencyMapper.mapFrom(currency)
            }
        }

    override fun registerUser(userRegister: RegisterEntity): Completable =
        apiService.registerUser(registerMapper.mapFrom(userRegister))

    override fun registerUserSingle(user: RegisterEntity): Single<TokenResponseEntity> =
        apiService.registerUserSingle(registerMapper.mapFrom(user)).map {
            responseMapper.mapFrom(it)
        }

    override fun logIn(user: LogInEntity): Completable {
        return apiService.logIn(logInMapper.mapFrom(user))
    }

}