package com.example.data.di

import com.example.data.api.AccountApi
import com.example.data.repository.AccountRepositoryImpl
import com.example.domain.repository.AccountRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
sealed class AccountApiModule {

    @Binds
    abstract fun provideAccountRepository(repository: AccountRepositoryImpl): AccountRepository

    companion object {
        @Provides
        fun provideApiService(retrofit: Retrofit): AccountApi {
            return retrofit.create(AccountApi::class.java)
        }
    }
}