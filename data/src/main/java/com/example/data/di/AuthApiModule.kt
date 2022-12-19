package com.example.data.di

import com.example.data.api.AuthApi
import com.example.data.repository.AuthRepositoryImpl
import com.example.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
sealed class AuthApiModule {

    @Binds
    abstract fun provideAuthRepository(repository: AuthRepositoryImpl): AuthRepository

    companion object {
        @Provides
        fun provideApiService(retrofit: Retrofit): AuthApi {
            return retrofit.create(AuthApi::class.java)
        }
    }
}