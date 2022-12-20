package com.example.ui.home

import com.example.base.AsyncResult
import com.example.base.Uninitialized
import com.example.domain.model.message.GetMessagesResponse

internal data class HomeState(
    val messagesResponse: AsyncResult<GetMessagesResponse> = Uninitialized
)