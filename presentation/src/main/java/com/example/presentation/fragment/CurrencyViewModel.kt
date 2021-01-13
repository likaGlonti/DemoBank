package com.example.presentation.fragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetCurrencyUseCase
import com.example.presentation.model.CurrencyBuyingRatePresentation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CurrencyViewModel @ViewModelInject constructor(
    private val currencyUseCase: GetCurrencyUseCase,
) : ViewModel() {

    val onErrorLiveData = MutableLiveData<Throwable>()

    val currencyBuyingRateLiveData = MutableLiveData<MutableList<CurrencyBuyingRatePresentation>>()

    private val bag = CompositeDisposable()

    init {
        currencyUseCase.invoke().filter { it ->
            it.any { it.currencyCountryFlag.isNotEmpty() }

        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe( {
                it.forEach { currencyEntity ->
                    currencyBuyingRateLiveData.value?.add(
                        CurrencyBuyingRatePresentation(
                            currencyEntity.buyRate.toString(),
                            currencyEntity.currencyCountryFlag,
                            currencyEntity.currencyName,
                        )
                    )
                }
            },
                {
                    onErrorLiveData.value = it
                }).let {
                bag.add(it)
            }
    }
}