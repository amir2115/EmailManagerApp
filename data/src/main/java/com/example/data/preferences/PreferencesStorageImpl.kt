package com.example.data.preferences

import android.content.SharedPreferences
import com.example.domain.preferences.PreferencesStorage
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesStorageImpl @Inject constructor(
    prefs: SharedPreferences
) : PreferencesStorage {

    override var tokenCode: String? by StringPreference(prefs, PREF_AUTH_TOKEN_KEY, null)

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