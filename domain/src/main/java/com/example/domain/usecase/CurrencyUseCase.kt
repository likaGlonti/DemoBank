package com.example.domain.usecase

import com.example.domain.repository.Repository
import com.example.domain.models.CurrencyEntity
import io.reactivex.Observable
import javax.inject.Inject

class GetCurrencyUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(): Observable<List<CurrencyEntity>> =
        repository.getCurrency()
}