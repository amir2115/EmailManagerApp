package com.example.ui.profile

internal sealed class ProfileAction {
    object NavigateUp : ProfileAction()
    data class NavigateToScreen(val route: String) : ProfileAction()
}
