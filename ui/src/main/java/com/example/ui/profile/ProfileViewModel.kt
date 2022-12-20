package com.example.ui.profile

import androidx.lifecycle.viewModelScope
import com.example.common_compose.base.BaseViewModel
import com.example.domain.usecase.account.GetMeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ProfileViewModel @Inject constructor(
    private val getMyAccountUseCase: GetMeUseCase
) : BaseViewModel<ProfileState, ProfileAction>(ProfileState()) {

    init {
        getProfile()

        onEachAction { action ->
            when (action) {
                else -> throw IllegalArgumentException("unknown action: $action")
            }
        }
    }

    private fun getProfile() {
        viewModelScope.launch {
            suspend {
                getMyAccountUseCase(Unit)
            }.execute {
                copy(profileResponse = it)
            }
        }
    }
}