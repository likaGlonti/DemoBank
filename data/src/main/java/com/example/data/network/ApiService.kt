package com.example.data.network

import com.example.data.models.Currency
import com.example.data.models.Register
import io.reactivex.Completable
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("rates/{path}")
    fun getCurrencyTest(@Path("path") currency:String?) : Observable<List<Currency>>

    @POST("v1/register")
    fun registerUser(@Body user: Register): Completable

}