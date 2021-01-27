package com.example.demobank.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.data.manager.SessionManager
import com.example.data.mappers.currency.CurrencyMapper
import com.example.data.mappers.authorize.RegisterMapper
import com.example.data.mappers.response.LogInMapper
import com.example.data.mappers.response.LoginResponseMapper
import com.example.data.mappers.response.RegistrationResponseMapper
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
    fun provideRetrofitInstance(sessionManager: SessionManager): Retrofit =
        getRetrofitInstance(sessionManager)

    @Provides
    fun provideGlideInstance(
        @ApplicationContext appContext: Context,
        requestOptions: RequestOptions
    ): RequestManager = Glide.with(appContext).setDefaultRequestOptions(requestOptions)

    @Provides
    fun providesRepository(
        apiService: ApiService,
        registerMapper: RegisterMapper,
        currencyMapper: CurrencyMapper,
        registrationResponseMapper: RegistrationResponseMapper,
        logInMapper: LogInMapper,
        loginResponseMapper: LoginResponseMapper,
    ): Repository =
        RepositoryImpl(
            apiService,
            registerMapper,
            currencyMapper,
            registrationResponseMapper,
            logInMapper,
            loginResponseMapper,
        )

    @Provides
    fun provideSessionManager(@ApplicationContext appContext: Context) = SessionManager(appContext)

}