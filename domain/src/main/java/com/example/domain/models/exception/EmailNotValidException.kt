package com.example.domain.models.exception

import java.lang.Exception

class EmailNotValidException : Exception(EMAIL_ADDRESS_NOT_VALID) {
    companion object {
        private const val EMAIL_ADDRESS_NOT_VALID = "Please, enter a valid email"
    }
}