package com.example.data.preferences

interface PreferencesStorage {
    var tokenCode: String?

    fun clearData()
    fun signOut()
}