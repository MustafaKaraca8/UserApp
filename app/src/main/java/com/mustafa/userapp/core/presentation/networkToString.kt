package com.mustafa.userapp.core.presentation

import android.content.Context
import com.mustafa.userapp.R
import com.mustafa.userapp.core.domain.NetworkError

fun NetworkError.toString(context: Context): String {
    val resId = when (this) {
        NetworkError.REQUEST_TIMEOUT -> R.string.error_request_timeout
        NetworkError.TOO_MANY_REQUEST -> R.string.error_too_many_request
        NetworkError.NO_INTERNET -> R.string.error_no_internet
        NetworkError.SERVER_ERROR -> R.string.error_server
        NetworkError.SERIALIZATION -> R.string.error_serialization
        NetworkError.UNKNOWN -> R.string.error_too_many_request
    }

    return context.getString(resId)
}