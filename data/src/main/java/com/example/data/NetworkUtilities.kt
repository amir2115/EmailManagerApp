package com.example.data

import retrofit2.HttpException
import retrofit2.Response

fun <T> Response<T>.bodyOrThrow(): T {
    if (!isSuccessful) {
        val serverException = errorBody()?.string()?.let { errorString ->
            parseHttpException(errorString, code())
        }
        throw serverException ?: HttpException(this)
    }
    return body()!!
}

fun parseHttpException(errorString: String, errorCode: Int): Exception? {
    return try {
        Exception(errorCode.toString())
    } catch (@Suppress("TooGenericExceptionCaught") e: Exception) {
        null
    }
}