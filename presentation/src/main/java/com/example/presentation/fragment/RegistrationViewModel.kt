package com.example.presentation.fragment

import android.app.Person
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.HttpException
import com.example.domain.models.Email
import com.example.domain.models.Password
import com.example.domain.models.PersonalId
import com.example.domain.usecase.RegisterUseCase
import com.example.presentation.model.RegisterPresentation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RegistrationViewModel @ViewModelInject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val nameLiveData = MutableLiveData<String>()
    private val lastNameLiveData = MutableLiveData<String>()
    private val emailLiveData = MutableLiveData<String>()
    private val birthDateLiveData = MutableLiveData<String>()
    private val phoneNumberLiveData = MutableLiveData<String>()
    private val personalIdLiveData = MutableLiveData<String>()
    private val addressLiveData = MutableLiveData<String>()
    private val passwordLiveData = MutableLiveData<String>()
    private val passwordConfirmationLiveData = MutableLiveData<String>()


    val onErrorLiveData = MutableLiveData<Throwable>()

    val onCompleteLiveData = MutableLiveData<Boolean>()

    private val bag = CompositeDisposable()

    fun registerAndNavigateToCurrency() {

        val register = RegisterPresentation(
            nameLiveData.value.orEmpty(),
            lastNameLiveData.value.orEmpty(),
            Email( emailLiveData.value.orEmpty()),
            birthDateLiveData.value.orEmpty(),
            phoneNumberLiveData.value.orEmpty(),
            PersonalId(personalIdLiveData.value.orEmpty()),
            addressLiveData.value.orEmpty(),
            Password( passwordLiveData.value.orEmpty()),
            passwordConfirmationLiveData.value.orEmpty(),
        )

        registerUseCase.registerUser(register.createUser()).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                onCompleteLiveData.value = true
            }, { onError ->
                onErrorLiveData.value = onError
            }).disposedBy()

    }

    private fun Disposable.disposedBy() {
        bag.add(this)
    }

    fun getName(name: String) {
        nameLiveData.postValue(name)
    }

    fun getLastName(lastName: String) {
        lastNameLiveData.value = lastName
    }

    fun getEmail(email: String) {
        emailLiveData.value = email
    }

    fun getBirthDate(date: String) {
        birthDateLiveData.value = date
    }

    fun getPhoneNumber(number: String) {
        phoneNumberLiveData.value = number
    }

    fun getPersonalId(id: String) {
        personalIdLiveData.value = id
    }

    fun getAddress(address: String) {
        addressLiveData.value = address
    }

    fun getPassword(password: String) {
        passwordLiveData.value = password
    }

    fun getPasswordConfirmation(confirmation: String) {
        passwordConfirmationLiveData.value = confirmation
    }

    override fun onCleared() {
        super.onCleared()
        bag.clear()
    }
}