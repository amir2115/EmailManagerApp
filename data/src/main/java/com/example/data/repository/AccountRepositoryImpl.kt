package com.example.data.repository

import com.example.data.api.AccountApi
import com.example.data.bodyOrThrow
import com.example.domain.model.account.AddAccountRequest
import com.example.domain.model.account.CreateAccountResponse
import com.example.domain.repository.AccountRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccountRepositoryImpl @Inject constructor(
    private val accountApi: AccountApi
) : AccountRepository {

    override suspend fun addAccount(addAccountRequest: AddAccountRequest) {
        return accountApi.addAccount(addAccountRequest).bodyOrThrow()
    }

    override suspend fun deleteAccount(id: String) {
        return accountApi.deleteAccount(id).bodyOrThrow()
    }

    override suspend fun getAccount(): CreateAccountResponse {
        return accountApi.getAccount().bodyOrThrow()
    }

}