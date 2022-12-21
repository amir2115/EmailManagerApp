package com.example.ui.message

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.common_compose.base.BaseViewModel
import com.example.domain.usecase.message.GetMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MessageViewModel @Inject constructor(
    private val getMessageUseCase: GetMessageUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<MessageState, MessageAction>(
    MessageState(
        id = savedStateHandle.get<String>("id")!!
    )
) {

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
                getMessageUseCase(state.id)
            }.execute {
                copy(messageResponse = it)
            }
        }
    }
}