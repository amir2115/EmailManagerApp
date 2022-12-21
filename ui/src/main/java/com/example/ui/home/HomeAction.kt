package com.example.ui.home

internal sealed class HomeAction {
    object Refresh : HomeAction()
    object OpenDrawer : HomeAction()
    object Logout : HomeAction()
    data class NavigateToScreen(val route: String) : HomeAction()
}
