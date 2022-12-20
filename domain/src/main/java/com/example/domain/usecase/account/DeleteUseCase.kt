package com.example.domain.usecase.account

import com.example.base.IoDispatcher
import com.example.domain.repository.AccountRepository
import com.example.domain.usecase.NoResultUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class DeleteUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val repository: AccountRepository
) : NoResultUseCase<String>(dispatcher) {

    override suspend fun doWork(params: String) {
        return repository.deleteAccount(params)
    }
}
