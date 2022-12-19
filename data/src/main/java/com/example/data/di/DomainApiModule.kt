package com.example.data.di

import com.example.data.api.DomainApi
import com.example.data.repository.DomainRepositoryImpl
import com.example.domain.repository.DomainRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
sealed class DomainApiModule {

    @Binds
    abstract fun provideDomainRepository(repository: DomainRepositoryImpl): DomainRepository

    companion object {
        @Provides
        fun provideApiService(retrofit: Retrofit): DomainApi {
            return retrofit.create(DomainApi::class.java)
        }
    }
}