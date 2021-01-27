package com.example.presentation.utils

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import com.example.presentation.R

fun Fragment.showErrorDialog(title: String?, message: String) {
    AlertDialog.Builder(context).setTitle(title).setMessage(message)
        .setNeutralButton(R.string.ok) { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }.show()
}

fun (() -> Any?).delayed(delayMills: Long) {
    Handler(Looper.getMainLooper()).postDelayed({
        this()
    }, delayMills)
}