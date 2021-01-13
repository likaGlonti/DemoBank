package com.example.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Currency(
    val currency: String,
    val currencyName: String,
    val buyRate: Float,
    val sellRate: Float,
    val nbgRate: Float,
    val currencyCountryFlag: String
)