package com.example.data.models

data class Currency(
    val currency: String,
    val currencyName: String,
    val buyRate: Float,
    val sellRate: Float,
    val nbgRate: Float,
    val currencyCountryFlag: String
)