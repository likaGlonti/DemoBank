package com.example.domain.models

data class CurrencyEntity (
    val currency: String,
    val currencyName: String,
    val buyRate: Float,
    val sellRate: Float,
    val nbgRate: Float,
    val currencyCountryFlag: String
)
