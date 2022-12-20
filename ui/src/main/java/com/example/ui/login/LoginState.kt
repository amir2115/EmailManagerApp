package com.example.ui.login

import com.example.base.AsyncResult
import com.example.base.Uninitialized

internal data class LoginState(
    val messagesResponse: AsyncResult<Unit> = Uninitialized
)