package com.example.domain.usecase.account

import com.example.base.IoDispatcher
import com.example.domain.model.account.CreateAccountResponse
import com.example.domain.repository.AccountRepository
import com.example.domain.usecase.ResultUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetMeUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val repository: AccountRepository
) : ResultUseCase<Unit, CreateAccountResponse>(dispatcher) {

    override suspend fun doWork(params: Unit): CreateAccountResponse {
        return repository.getAccount()
    }
}
