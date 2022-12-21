package com.example.ui.message

internal sealed class MessageAction {
    object NavigateUp : MessageAction()
    object Delete : MessageAction()
    data class NavigateToScreen(val route: String) : MessageAction()
}
