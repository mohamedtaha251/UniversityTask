package com.example.universitytask.ui.theme

import android.content.Context
import android.os.Build
import android.text.TextUtils
import android.widget.Toast


fun Context.showLongToast(message: String?) {
    makeToast(message.toString(), this, Toast.LENGTH_LONG)
}

fun Context.showShortToast(message: String?) {
    makeToast(message.toString(), this, Toast.LENGTH_SHORT)
}

private fun makeToast(message: String, context: Context?, duration: Int) {
    if (TextUtils.isEmpty(message))
        return

    try {
        // we use toast compat to solve thrown BadTokenException on Android 7.1.1
        // https://github.com/PureWriter/ToastCompat#usage
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.N_MR1)
            Toast.makeText(context, message, duration).show()
        else
            Toast.makeText(context, message, duration).show()
    } catch (ex: Exception) {
        // https://developpaper.com/question/have-you-ever-encountered-badtoken-exception-errors-caused-by-toast-reported-only-on-android-7-1/
        // on Android 7.1.1, Toast will throw BadTokenException if it passes 3.5 secs without being handled
    }
}

