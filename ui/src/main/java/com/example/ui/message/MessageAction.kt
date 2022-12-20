package com.example.ui.message

internal sealed class MessageAction {
    object Refresh : MessageAction()
    data class NavigateToScreen(val route: String) : MessageAction()
}
