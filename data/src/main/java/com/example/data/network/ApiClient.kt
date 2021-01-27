package com.example.data.network

import com.example.data.manager.SessionManager
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit


@OptIn(kotlinx.serialization.ExperimentalSerializationApi::class)
fun getRetrofitInstance(sessionManager: SessionManager): Retrofit = Retrofit.Builder()
    .baseUrl("http://online.cloud.com.ge/api/")
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .addConverterFactory(Json {
        isLenient = true
        coerceInputValues = true
        allowSpecialFloatingPointValues = true
    }.asConverterFactory("application/json".toMediaType()))
    .client(getClient(sessionManager))
    .build()

fun getClient(sessionManager: SessionManager) =
    OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(getHttpLoggingInterceptor())
        .addInterceptor(getAuthInterceptor(sessionManager))
        .build()


fun getHttpLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
    HttpLoggingInterceptor.Level.BODY
)

fun getAuthInterceptor(sessionManager: SessionManager): Interceptor {
    return Interceptor { chain ->
        val requestBuilder = chain.request().newBuilder()
        sessionManager.fetchAuthToken()?.let {
            requestBuilder.addHeader("Authorization", "Bearer $it")
        }
        chain.proceed(requestBuilder.build())
    }
}

