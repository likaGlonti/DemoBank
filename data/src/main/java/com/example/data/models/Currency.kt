package com.example.data.models

import kotlinx.serialization.Serializable
import retrofit2.http.Url

@Serializable
data class Currency(
    val currency: String,
    val currencyName: String,
    val buyRate: Float = 0.0f,
    val sellRate: Float = 0.0f,
    val nbgRate: Float = 0.0f,
    val currencyCountryFlag: String
)