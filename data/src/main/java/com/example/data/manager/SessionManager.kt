package com.example.data.manager

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

open class SessionManager @Inject constructor(private val context: Context) {

    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE)

    fun saveAuthToken(token: String) {
        val editPreferences = sharedPreferences.edit()
        editPreferences.putString(USER_TOKEN, token)
        editPreferences.apply()
    }

    fun fetchAuthToken():String? = sharedPreferences.getString(USER_TOKEN, "")

    companion object {
        const val USER_TOKEN = "user_token"
    }

}