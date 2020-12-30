package com.example.domain.models

import java.util.regex.Pattern

class Email(private val email: String) {

    fun isValid(): Boolean = EMAIL_ADDRESS_PATTERN.matcher(email).matches()

    override fun toString(): String {
        return email
    }

    companion object {
        private val EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
    }
}