package com.example.presentation.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.manager.SessionManager
import com.example.domain.models.Email
import com.example.domain.models.Password
import com.example.domain.usecase.LogInUseCase
import com.example.presentation.model.LogInPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val logInUseCase: LogInUseCase,
    private val sessionManager: SessionManager,
) :
    ViewModel() {

    val onErrorLiveData = MutableLiveData<Throwable>()

    val onCompleteLiveData = MutableLiveData<Boolean>()

    private val bag = CompositeDisposable()

    fun logIn(email: String, password: String) {
        val logIn = LogInPresentation(
            Email(email),
            Password(password),
        )
        logInUseCase.logIn(logIn.getLogIn()).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({ tokenResponse ->
                sessionManager.saveAuthToken(tokenResponse.token)
                onCompleteLiveData.value = true
            }, { onError ->
                onErrorLiveData.value = onError
            }).let {
                bag.add(it)
            }
    }
}