package com.example.data.mappers.currency

import com.example.data.mappers.Mapper
import com.example.data.models.Currency
import com.example.domain.models.entity.CurrencyEntity
import javax.inject.Inject

open class CurrencyMapper @Inject constructor() : Mapper<Currency, CurrencyEntity> {
    override fun mapFrom(model: Currency): CurrencyEntity {
        return CurrencyEntity(
            model.currency,
            model.currencyName,
            model.buyRate,
            model.sellRate,
            model.nbgRate,
            model.currencyCountryFlag
        )
    }
}