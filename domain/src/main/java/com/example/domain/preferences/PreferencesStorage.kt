package com.example.domain.preferences

interface PreferencesStorage {
    var tokenCode: String?

    fun clearData()
    fun signOut()
}