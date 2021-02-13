package com.example.presentation.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetCurrencyUseCase
import com.example.presentation.utils.toCurrencyPresentation
import com.example.presentation.model.CurrencyBuyingRatePresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(private val currencyUseCase: GetCurrencyUseCase) :
    ViewModel() {

    val onErrorLiveData = MutableLiveData<Throwable>()
    val onCompleteLiveData = MutableLiveData<Boolean>()

    val currencyBuyingRateLiveData = MutableLiveData<MutableList<CurrencyBuyingRatePresentation>>()

    private val bag = CompositeDisposable()

    init {
        currencyUseCase.invoke().delay(5, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({ currencies ->
                val value = currencyBuyingRateLiveData.value ?: mutableListOf()
                value.addAll(currencies.map { it.toCurrencyPresentation() })
                currencyBuyingRateLiveData.value = value
                onCompleteLiveData.value = true
            },
                {
                    onErrorLiveData.value = it
                }).let {
                bag.add(it)
            }
    }
}