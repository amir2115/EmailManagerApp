package com.example.domain.preferences

import kotlinx.coroutines.flow.Flow

interface PreferencesStorage {
    var observableToken: Flow<String>
    var tokenCode: String?

    fun clearData()
    fun signOut()
}