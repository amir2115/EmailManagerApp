package com.example.ui.home

import androidx.lifecycle.viewModelScope
import com.example.common_compose.base.BaseViewModel
import com.example.domain.preferences.PreferencesStorage
import com.example.domain.usecase.message.GetMessagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getMessagesUseCase: GetMessagesUseCase,
    private val sharedPreferences: PreferencesStorage
) : BaseViewModel<HomeState, HomeAction>(HomeState()) {

    init {
        getMessages()

        onEachAction { action ->
            when (action) {
                is HomeAction.Refresh -> {
                    getMessages()
                }
                is HomeAction.Logout -> {
                    sharedPreferences.signOut()
                }
                else -> throw IllegalArgumentException("unknown action: $action")
            }
        }
    }

    private fun getMessages() {
        viewModelScope.launch {
            suspend {
                getMessagesUseCase(Unit)
            }.execute {
                copy(messagesResponse = it)
            }
        }
    }
}