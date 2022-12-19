package com.example.ui.home

import com.example.base.AsyncResult
import com.example.base.Uninitialized

internal data class HomeState(
    val messagesResponse: AsyncResult<Unit> = Uninitialized
)