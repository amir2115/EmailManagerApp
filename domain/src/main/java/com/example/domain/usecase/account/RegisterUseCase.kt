package com.example.domain.usecase.account

import com.example.base.IoDispatcher
import com.example.domain.model.account.AddAccountRequest
import com.example.domain.repository.AccountRepository
import com.example.domain.usecase.NoResultUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val repository: AccountRepository
) : NoResultUseCase<AddAccountRequest>(dispatcher) {

    override suspend fun doWork(params: AddAccountRequest) {
        return repository.addAccount(params)
    }
}
