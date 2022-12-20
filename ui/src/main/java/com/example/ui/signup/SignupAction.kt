package com.example.ui.signup

internal sealed class SignupAction {
    object Signup : SignupAction()
    data class OnValueChanged(val key: Int, val value: String) : SignupAction()
    data class NavigateToScreen(val route: String) : SignupAction()
}
