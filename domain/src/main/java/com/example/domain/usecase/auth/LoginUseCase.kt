package com.example.domain.usecase.auth

import com.example.base.IoDispatcher
import com.example.domain.model.auth.GetTokenRequest
import com.example.domain.model.auth.GetTokenResponse
import com.example.domain.preferences.PreferencesStorage
import com.example.domain.repository.AuthRepository
import com.example.domain.usecase.ResultUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val repository: AuthRepository,
    private val sharedPreferences: PreferencesStorage
) : ResultUseCase<GetTokenRequest, GetTokenResponse>(dispatcher) {

    override suspend fun doWork(params: GetTokenRequest): GetTokenResponse {
        val response = repository.getToken(params)
        sharedPreferences.tokenCode = response.token
        return response
    }
}
