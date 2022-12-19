package com.example.ui.home

internal sealed class HomeAction {
    object Refresh : HomeAction()
    data class NavigateToScreen(val route : String) : HomeAction()
}
