package com.example.emailmanagerapp.main

import com.example.common_compose.base.BaseViewModel
import com.example.domain.preferences.PreferencesStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    preferencesStorage: PreferencesStorage
) : BaseViewModel<MainState, MainAction>(
    MainState(
        token = preferencesStorage.tokenCode ?: ""
    )
)
