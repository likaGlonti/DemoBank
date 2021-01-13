package com.example.data.network

import com.example.data.models.Currency
import com.example.data.models.LogIn
import com.example.data.models.Register
import com.example.data.models.TokenResponse
import com.example.domain.models.entity.RegisterEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("rates/{path}")
    fun getCurrencyTest(@Path("path") currency:String?) : Observable<List<Currency>>

    @POST("register")
    fun registerUser(@Body user: Register): Completable

    @POST("register")
    fun registerUserSingle(@Body user: Register): Single<TokenResponse>

    @POST("login")
    fun logIn(@Body user:LogIn):Completable

}