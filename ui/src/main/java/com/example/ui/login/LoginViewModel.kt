package com.example.ui.login

import com.example.common_compose.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class LoginViewModel @Inject constructor(

) : BaseViewModel<LoginState, LoginAction>(LoginState()) {

    init {
        onEachAction { action ->
            when (action) {
                is LoginAction.Refresh -> {

                }
                else -> throw IllegalArgumentException("unknown action: $action")
            }
        }
    }
}