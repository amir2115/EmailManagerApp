package com.example.data.repository

import com.example.data.api.DomainApi
import com.example.data.bodyOrThrow
import com.example.domain.model.domain.GetDomainsResponse
import com.example.domain.repository.DomainRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DomainRepositoryImpl @Inject constructor(
    private val domainApi: DomainApi
) : DomainRepository {

    override suspend fun getDomains(): GetDomainsResponse {
        return domainApi.getDomains().bodyOrThrow()
    }
}