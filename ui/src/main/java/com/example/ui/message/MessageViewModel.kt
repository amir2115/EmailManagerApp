package com.example.ui.message

import androidx.lifecycle.viewModelScope
import com.example.common_compose.base.BaseViewModel
import com.example.domain.usecase.message.GetMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MessageViewModel @Inject constructor(
    private val getMessageUseCase: GetMessageUseCase
) : BaseViewModel<MessageState, MessageAction>(MessageState()) {

    init {
        getMessage()

        onEachAction { action ->
            when (action) {
                is MessageAction.Refresh -> {

                }
                else -> throw IllegalArgumentException("unknown action: $action")
            }
        }
    }

    private fun getMessage() {
        viewModelScope.launch {
            suspend {
                getMessageUseCase("")
            }.execute {
                copy(messageResponse = it)
            }
        }
    }
}