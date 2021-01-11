package com.example.demobank.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.data.mappers.currency.CurrencyMapper
import com.example.data.mappers.register.RegisterMapper
import com.example.data.network.ApiService
import com.example.data.network.getRetrofitInstance
import com.example.data.repo.RepositoryImpl
import com.example.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideApiServices(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideRetrofitInstance(): Retrofit = getRetrofitInstance()

    @Provides
    fun provideGlideInstance(
        @ApplicationContext appContext: Context,
        requestOptions: RequestOptions
    ): RequestManager = Glide.with(appContext).setDefaultRequestOptions(requestOptions)

    @Provides
    fun providesRepository(apiService: ApiService, registerMapper: RegisterMapper, currencyMapper: CurrencyMapper): Repository = RepositoryImpl(apiService, registerMapper, currencyMapper)

}