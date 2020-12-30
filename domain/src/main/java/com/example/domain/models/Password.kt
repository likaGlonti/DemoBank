package com.example.domain.models

import com.example.domain.models.exception.PasswordNotValidException
import java.lang.Exception

class Password(private val password: String) {

    private val isUpper = password[0].isUpperCase()
    private val isLong = password.toCharArray().count() > 6

    fun isValid(onError: (Exception) -> Unit): Boolean {
        if (!isUpper) {
            onError(PasswordNotValidException(PASSWORD_UPPER_CASE))
            return false
        }
        if (!isLong) {
            onError(PasswordNotValidException(PASSWORD_LENGTH))
            return false
        }
        return true
    }

    override fun toString(): String {
        return password
    }

    companion object {
        private const val PASSWORD_UPPER_CASE = "first letter should be upper case"
        private const val PASSWORD_LENGTH = "please enter 6 character password"
    }
}