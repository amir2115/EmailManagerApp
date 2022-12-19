package com.example.data.interceptor

import com.example.data.preferences.PreferencesStorageImpl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val sharedPreferences: PreferencesStorageImpl
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return sharedPreferences.tokenCode?.let { authToken ->
            val modifiedRequest = chain.request()
                .newBuilder()
                .header("Authorization", "Bearer $authToken")
                .build()
            chain.proceed(modifiedRequest)
        } ?: chain.proceed(chain.request())
    }
}
