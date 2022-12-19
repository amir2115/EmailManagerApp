package com.example.domain.repository

import com.example.domain.model.account.AddAccountRequest
import com.example.domain.model.account.CreateAccountResponse

interface AccountRepository {
    suspend fun addAccount(addAccountRequest: AddAccountRequest)
    suspend fun deleteAccount(id: String)
    suspend fun getAccount(): CreateAccountResponse
}