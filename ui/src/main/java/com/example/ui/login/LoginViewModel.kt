package com.example.ui.login

import androidx.lifecycle.viewModelScope
import com.example.common_compose.base.BaseViewModel
import com.example.domain.model.auth.GetTokenRequest
import com.example.domain.usecase.auth.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel<LoginState, LoginAction>(LoginState()) {

    init {
        onEachAction { action ->
            when (action) {
                is LoginAction.Login -> login()
                is LoginAction.OnValueChanged -> onValueChanged(action.key, action.value)
                else -> throw IllegalArgumentException("unknown action: $action")
            }
        }
    }

    private fun onValueChanged(key: Int, value: String) {
        when (key) {
            EMAIL_KEY -> setState { copy(email = value) }
            PASSWORD_KEY -> setState { copy(password = value) }
        }
    }

    private fun login() {
        viewModelScope.launch {
            suspend {
                val params = GetTokenRequest(
                    address = state.email,
                    password = state.password
                )
                loginUseCase(params)
            }.execute {
                copy(loginResponse = it)
            }
        }
    }

    companion object {
        const val EMAIL_KEY = 1
        const val PASSWORD_KEY = 2
    }
}