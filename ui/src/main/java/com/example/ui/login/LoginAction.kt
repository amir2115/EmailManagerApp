package com.example.ui.login

internal sealed class LoginAction {
    object Refresh : LoginAction()
    data class NavigateToScreen(val route: String) : LoginAction()
}
