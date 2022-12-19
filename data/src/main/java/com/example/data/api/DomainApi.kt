package com.example.data.api

import com.example.domain.model.domain.GetDomainsResponse
import retrofit2.Response
import retrofit2.http.GET

interface DomainApi {
    @GET("/domains")
    suspend fun getDomains(): Response<GetDomainsResponse>
}