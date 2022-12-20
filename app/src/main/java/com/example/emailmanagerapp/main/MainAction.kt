package com.example.emailmanagerapp.main

internal sealed class MainAction {
    data class NavigateToScreen(val route: String) : MainAction()
}
