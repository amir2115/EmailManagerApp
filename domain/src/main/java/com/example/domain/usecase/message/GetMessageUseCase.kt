package com.example.domain.usecase.message

import com.example.base.IoDispatcher
import com.example.domain.model.message.GetMessageResponse
import com.example.domain.repository.MessageRepository
import com.example.domain.usecase.ResultUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetMessageUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val repository: MessageRepository
) : ResultUseCase<String, GetMessageResponse>(dispatcher) {

    override suspend fun doWork(params: String): GetMessageResponse {
        return repository.getMessage(params)
    }
}
