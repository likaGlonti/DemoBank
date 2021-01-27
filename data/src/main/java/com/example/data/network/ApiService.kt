package com.example.data.network

import com.example.data.models.*
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("v1/rates/currency-rates")
    fun getCurrencyTest(): Observable<List<Currency>>

    @POST("v1/register")
    fun registerUserSingle(@Body user: Register): Single<TokenResponseRegistration>

    @POST("v1/login")
    fun logIn(@Body user: LogIn): Single<TokenResponseLogIn>

}