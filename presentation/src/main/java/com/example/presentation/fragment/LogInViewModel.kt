package com.example.presentation.fragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Email
import com.example.domain.models.Password
import com.example.domain.usecase.LogInUseCase
import com.example.presentation.model.LogInPresentation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LogInViewModel @ViewModelInject constructor(private val logInUseCase: LogInUseCase) :
    ViewModel() {
    private val emailLiveData = MutableLiveData<String>()
    private val passwordLiveData = MutableLiveData<String>()

    val onErrorLiveData = MutableLiveData<Throwable>()

    val onCompleteLiveData = MutableLiveData<Boolean>()

    private val bag = CompositeDisposable()

    fun logIn(email: String, password: String) {
        val logIn = LogInPresentation(
            Email(email),
            Password(password),
        )
        logInUseCase.logIn(logIn.getLogIn()).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                onCompleteLiveData.value = true
            }, { onError ->
                onErrorLiveData.value = onError
            }).let {
            bag.add(it)
        }
    }

    fun getEmail(email: String) {
        emailLiveData.value = email
    }

    fun getPassword(password: String) {
        passwordLiveData.value = password
    }
}