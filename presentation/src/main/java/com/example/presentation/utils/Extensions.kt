package com.example.presentation.utils

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.fragment.app.Fragment
import com.example.presentation.R
import com.example.presentation.adapter.CurrencyBuyingRateAdapter

fun Fragment.showErrorDialog(title: String?, message: String) {
    AlertDialog.Builder(context).setTitle(title).setMessage(message).
        setNeutralButton(R.string.ok) { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }.show()
}
