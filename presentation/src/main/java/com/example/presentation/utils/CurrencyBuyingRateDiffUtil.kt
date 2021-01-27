package com.example.presentation.utils

import com.example.presentation.model.CurrencyBuyingRatePresentation

class CurrencyBuyingRateDiffUtil(
    oldList: List<CurrencyBuyingRatePresentation>,
    newList: MutableList<CurrencyBuyingRatePresentation>,
) : DemoBankDiffUtil<CurrencyBuyingRatePresentation>(oldList, newList)