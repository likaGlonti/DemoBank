package com.example.data.repo

import com.example.data.mappers.currency.CurrencyMapper
import com.example.data.mappers.authorize.RegisterMapper
import com.example.data.mappers.response.LogInMapper
import com.example.data.mappers.response.LoginResponseMapper
import com.example.data.mappers.response.RegistrationResponseMapper
import com.example.data.network.ApiService
import com.example.domain.models.entity.*
import com.example.domain.repository.Repository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val registerMapper: RegisterMapper,
    private val currencyMapper: CurrencyMapper,
    private val registrationResponseMapper: RegistrationResponseMapper,
    private val logInMapper: LogInMapper,
    private val loginResponseMapper: LoginResponseMapper,

) :
    Repository {
    override fun getCurrency(): Observable<List<CurrencyEntity>> =
        apiService.getCurrencyTest().map {
            it.map { currency ->
                currencyMapper.mapFrom(currency)
            }
        }

    override fun registerUserSingle(user: RegisterEntity): Single<TokenRegistrationResponseEntity> =
        apiService.registerUserSingle(registerMapper.mapFrom(user)).map {
            registrationResponseMapper.mapFrom(it)
        }

    override fun logIn(user: LogInEntity): Single<TokenResponseLoginEntity> =
        apiService.logIn(logInMapper.mapFrom(user)).map { loginResponseMapper.mapFrom(it) }

}