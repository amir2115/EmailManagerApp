package com.example.data.di

import com.example.data.api.MessageApi
import com.example.data.repository.MessageRepositoryImpl
import com.example.domain.repository.MessageRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
sealed class MessageApiModule {

    @Binds
    abstract fun provideMessageRepository(repository: MessageRepositoryImpl): MessageRepository

    companion object {
        @Provides
        fun provideApiService(retrofit: Retrofit): MessageApi {
            return retrofit.create(MessageApi::class.java)
        }
    }
}