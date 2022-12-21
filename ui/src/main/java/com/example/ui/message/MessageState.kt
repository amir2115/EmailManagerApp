package com.example.ui.message

import com.example.base.AsyncResult
import com.example.base.Uninitialized
import com.example.domain.model.message.GetMessageResponse

internal data class MessageState(
    val messageResponse: AsyncResult<GetMessageResponse> = Uninitialized,
    val deleteMessageResponse: AsyncResult<Unit> = Uninitialized,
    val id: String = ""
)