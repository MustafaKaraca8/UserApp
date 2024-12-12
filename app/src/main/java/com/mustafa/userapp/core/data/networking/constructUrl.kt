package com.mustafa.userapp.core.data.networking

import com.mustafa.userapp.BuildConfig

fun constructUr(url: String): String {
    return when {
        url.contains(BuildConfig.BASE_URL) -> url
        url.startsWith("/") -> BuildConfig.BASE_URL + url.drop(1)
        else -> BuildConfig.BASE_URL + url
    }
}