package com.example.ui.signup

import com.example.common_compose.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class SignupViewModel @Inject constructor(

) : BaseViewModel<SignupState, SignupAction>(SignupState()) {

    init {
        onEachAction { action ->
            when (action) {
                is SignupAction.Refresh -> {

                }
                else -> throw IllegalArgumentException("unknown action: $action")
            }
        }
    }
}