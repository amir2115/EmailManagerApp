package com.example.domain.usecase.message

import com.example.base.IoDispatcher
import com.example.domain.model.message.GetMessagesResponse
import com.example.domain.repository.MessageRepository
import com.example.domain.usecase.ResultUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetMessagesUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val repository: MessageRepository
) : ResultUseCase<Unit, GetMessagesResponse>(dispatcher) {

    override suspend fun doWork(params: Unit): GetMessagesResponse {
        return repository.getMessages()
    }
}
