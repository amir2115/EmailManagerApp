package com.example.ui.profile

internal sealed class ProfileAction {
    data class NavigateToScreen(val route: String) : ProfileAction()
}
