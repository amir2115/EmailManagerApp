package com.example.data.preferences

import android.content.SharedPreferences
import com.example.domain.preferences.PreferencesStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesStorageImpl @Inject constructor(
    prefs: SharedPreferences
) : PreferencesStorage {

    override var tokenCode: String? by StringPreference(prefs, PREF_AUTH_TOKEN_KEY, null)

    private val tokenFlow: MutableStateFlow<String> by lazy {
        MutableStateFlow(tokenCode ?: "")
    }

    override var observableToken: Flow<String>
        get() = tokenFlow
        set(_) = throw IllegalAccessException("This property can't be changed")

    override fun clearData() {
        tokenCode = null
    }

    override fun signOut() {
        tokenCode = null
    }

    companion object PreferencesKey {
        private const val PREF_AUTH_TOKEN_KEY = "1"
        const val PREFS_NAME = "email_pref"
    }
}