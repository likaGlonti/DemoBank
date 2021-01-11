package com.example.domain.models


class PersonalId(private val id: String) {

    private fun isDigit(): Boolean {
        return id.isNotEmpty() && id.all { it.isDigit() }
    }

    fun isValid(): Boolean {
        return id.count() == 11 && isDigit()
    }

    override fun toString(): String {
        return id
    }

}