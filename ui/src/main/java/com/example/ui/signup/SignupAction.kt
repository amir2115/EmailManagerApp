package com.example.ui.signup

internal sealed class SignupAction {
    object Refresh : SignupAction()
    data class NavigateToScreen(val route: String) : SignupAction()
}
