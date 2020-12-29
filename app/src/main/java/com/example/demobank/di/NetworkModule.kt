package com.example.demobank.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.data.mappers.currency.CurrencyMapper
import com.example.data.mappers.register.RegisterMapper
import com.example.data.network.ApiService
import com.example.data.repo.RepositoryImpl
import com.example.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideApiServices(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideRetrofitInstance(): Retrofit =
        Retrofit.Builder().baseUrl("http://online.cloud.com.ge/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(client())
            .build()

    @Provides
    fun client() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Provides
    fun provideGlideInstance(
        @ApplicationContext appContext: Context,
        requestOptions: RequestOptions
    ): RequestManager = Glide.with(appContext).setDefaultRequestOptions(requestOptions)

    @Provides
    fun providesRepository(apiService: ApiService, registerMapper: RegisterMapper, currencyMapper: CurrencyMapper): Repository = RepositoryImpl(apiService, registerMapper, currencyMapper)

}