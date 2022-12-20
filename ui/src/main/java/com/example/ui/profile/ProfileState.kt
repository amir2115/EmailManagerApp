package com.example.ui.profile

import com.example.base.AsyncResult
import com.example.base.Uninitialized
import com.example.domain.model.account.CreateAccountResponse

internal data class ProfileState(
    val profileResponse: AsyncResult<CreateAccountResponse> = Uninitialized,
)