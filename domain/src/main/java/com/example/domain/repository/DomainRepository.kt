package com.example.domain.repository

import com.example.domain.model.domain.GetDomainsResponse

interface DomainRepository {
    suspend fun getDomains(): GetDomainsResponse
}