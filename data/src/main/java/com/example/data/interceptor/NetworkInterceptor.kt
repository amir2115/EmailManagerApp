package com.example.data.interceptor

import android.content.Context
import android.widget.Toast
import com.example.data.preferences.PreferencesStorageImpl
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkInterceptor @Inject constructor(
    private val sharedPreferences: PreferencesStorageImpl,
    @ApplicationContext private val context: Context,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            val response = chain.proceed(chain.request())
            when (response.code) {
                401 -> {
                    sharedPreferences.signOut()
                    response.body?.let {
                        Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
                in 300..600 -> {
                    response.body?.let {
                        Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
            return response
        } catch (e: Exception) {
            print(e.stackTrace)
        }
        return chain.proceed(chain.request())
    }
}
