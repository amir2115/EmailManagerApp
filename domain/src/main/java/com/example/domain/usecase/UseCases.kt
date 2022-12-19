package com.example.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

abstract class NoResultUseCase<in P>(private val dispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(params: P) {
        return withContext(dispatcher) {
            doWork(params)
        }
    }

    suspend fun executeSync(params: P) = doWork(params)

    protected abstract suspend fun doWork(params: P)
}

abstract class ResultUseCase<in P, out R>(private val dispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(params: P): R = withContext(dispatcher) { doWork(params) }

    suspend fun executeSync(params: P): R = doWork(params)

    protected abstract suspend fun doWork(params: P): R
}