package com.example.data.interceptor

import com.example.data.preferences.PreferencesStorageImpl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkInterceptor @Inject constructor(
    private val sharedPreferences: PreferencesStorageImpl,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            val response = chain.proceed(chain.request())
            when (response.code) {
                401 -> {
                    sharedPreferences.signOut()
                }
            }
            return response
        } catch (e: Exception) {
            print(e.stackTrace)
        }
        return chain.proceed(chain.request())
    }
}
