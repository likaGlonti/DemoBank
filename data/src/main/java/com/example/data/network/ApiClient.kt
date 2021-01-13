package com.example.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


@OptIn(kotlinx.serialization.ExperimentalSerializationApi::class)
fun getRetrofitInstance(): Retrofit = Retrofit.Builder()
    .baseUrl("http://online.cloud.com.ge/api/v1/")
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .addConverterFactory(Json {
        isLenient = true
    }.asConverterFactory("application/json".toMediaType()))
    .client(getClient())
    .build()

fun getClient() = OkHttpClient.Builder().addInterceptor(
    HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BODY
    )
).build()