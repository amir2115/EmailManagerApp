package com.example.domain.usecase.message

import com.example.base.IoDispatcher
import com.example.domain.repository.MessageRepository
import com.example.domain.usecase.NoResultUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class DeleteMessageUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val repository: MessageRepository
) : NoResultUseCase<String>(dispatcher) {

    override suspend fun doWork(params: String) {
        return repository.deleteMessage(params)
    }
}
