package com.example.domain.usecase.domain

import com.example.base.IoDispatcher
import com.example.domain.model.domain.GetDomainsResponse
import com.example.domain.repository.DomainRepository
import com.example.domain.usecase.ResultUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetDomainsUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val repository: DomainRepository
) : ResultUseCase<Unit, GetDomainsResponse>(dispatcher) {

    override suspend fun doWork(params: Unit): GetDomainsResponse {
        return repository.getDomains()
    }
}
