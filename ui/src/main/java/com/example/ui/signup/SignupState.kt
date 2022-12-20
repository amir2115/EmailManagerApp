package com.example.ui.signup

import com.example.base.AsyncResult
import com.example.base.Uninitialized

internal data class SignupState(
    val messagesResponse: AsyncResult<Unit> = Uninitialized
)