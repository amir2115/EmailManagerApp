package com.example.ui.signup

import androidx.lifecycle.viewModelScope
import com.example.common_compose.base.BaseViewModel
import com.example.domain.model.account.AddAccountRequest
import com.example.domain.usecase.account.RegisterUseCase
import com.example.domain.usecase.domain.GetDomainsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SignupViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val getDomainsUseCase: GetDomainsUseCase
) : BaseViewModel<SignupState, SignupAction>(SignupState()) {

    init {
        getDomains()

        onEachAction { action ->
            when (action) {
                is SignupAction.Signup -> login()
                is SignupAction.OnValueChanged -> onValueChanged(action.key, action.value)
                else -> throw IllegalArgumentException("unknown action: $action")
            }
        }

        onAsyncResult(SignupState::domainsResponse) {
            it.member.firstOrNull()?.let {
                setState { copy(domain = it.domain) }
            }
        }
    }

    private fun onValueChanged(key: Int, value: String) {
        when (key) {
            EMAIL_KEY -> setState { copy(email = value) }
            PASSWORD_KEY -> setState { copy(password = value) }
        }
    }

    private fun getDomains() {
        viewModelScope.launch {
            suspend {
                getDomainsUseCase(Unit)
            }.execute {
                copy(domainsResponse = it)
            }
        }
    }

    private fun login() {
        viewModelScope.launch {
            suspend {
                val params = AddAccountRequest(
                    address = "${state.email}@${state.domain}",
                    password = state.password
                )
                registerUseCase(params)
            }.execute {
                copy(signupResponse = it)
            }
        }
    }

    companion object {
        const val EMAIL_KEY = 1
        const val PASSWORD_KEY = 2
    }
}