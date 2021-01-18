package com.example.presentation.model

import javax.inject.Inject

class CurrencyBuyingRatePresentation @Inject constructor(
    val buyingRate: String,
    val countryFlag: String,
    val currencyName: String,
)