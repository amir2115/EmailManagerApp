package com.example.domain.usecase.auth

import com.example.base.IoDispatcher
import com.example.domain.model.auth.GetTokenRequest
import com.example.domain.model.auth.GetTokenResponse
import com.example.domain.repository.AuthRepository
import com.example.domain.usecase.ResultUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UserLoginUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val repository: AuthRepository
) : ResultUseCase<GetTokenRequest, GetTokenResponse>(dispatcher) {

    override suspend fun doWork(params: GetTokenRequest): GetTokenResponse {
        return repository.getToken(params)
    }
}
