package com.example.presentation.common

import coil.load
import com.example.presentation.R
import com.example.presentation.databinding.CurrencyItemLayoutBinding
import com.example.presentation.model.CurrencyBuyingRatePresentation

fun CurrencyItemLayoutBinding.bindWith(presentation:CurrencyBuyingRatePresentation){
    buyRate.text = presentation.buyingRate
    currencyName.text = presentation.currencyName
    countryFlag.load(presentation.countryFlag){
        crossfade(500)
        placeholder(R.drawable.ic_monet_placeholder)
    }
}