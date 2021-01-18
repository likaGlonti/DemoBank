package com.example.presentation.utils

import com.example.domain.models.entity.CurrencyEntity
import com.example.presentation.model.CurrencyBuyingRatePresentation

fun CurrencyEntity.toCurrencyPresentation() =
    CurrencyBuyingRatePresentation(
        buyRate.toString(),
        currencyCountryFlag,
        currencyName
    )