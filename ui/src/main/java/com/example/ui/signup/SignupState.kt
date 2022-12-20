package com.example.ui.signup

import com.example.base.AsyncResult
import com.example.base.Uninitialized
import com.example.domain.model.domain.GetDomainsResponse

internal data class SignupState(
    val domainsResponse: AsyncResult<GetDomainsResponse> = Uninitialized,
    val signupResponse: AsyncResult<Unit> = Uninitialized,
    val email: String = "",
    val password: String = ""
)