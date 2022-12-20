package com.example.ui.login

internal sealed class LoginAction {
    object Login : LoginAction()
    data class OnValueChanged(val key: Int, val value: String) : LoginAction()
    data class NavigateToScreen(val route: String) : LoginAction()
}
