package com.example.ui.login

import com.example.base.AsyncResult
import com.example.base.Uninitialized
import com.example.domain.model.auth.GetTokenResponse

internal data class LoginState(
    val loginResponse: AsyncResult<GetTokenResponse> = Uninitialized,
    val email: String = "",
    val password: String = ""
)