package com.example.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import collectAsState
import com.example.ui.login.LoginViewModel.Companion.EMAIL_KEY
import com.example.ui.login.LoginViewModel.Companion.PASSWORD_KEY

@Composable
fun LoginScreen(navController: NavController) {
    LoginScreen(
        navController,
        hiltViewModel()
    )
}

@Composable
internal fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val viewState by viewModel.collectAsState()

    LoginScreen(
        scaffoldState = scaffoldState,
        viewState = viewState,
    ) { action ->
        when (action) {
            is LoginAction.NavigateToScreen -> navController.navigate(action.route)
            else -> viewModel.submitAction(action)
        }
    }
}

@Composable
internal fun LoginScreen(
    scaffoldState: ScaffoldState,
    viewState: LoginState,
    action: (LoginAction) -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Login")
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = viewState.email,
                onValueChange = {
                    action(LoginAction.OnValueChanged(EMAIL_KEY, it))
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = viewState.password,
                onValueChange = {
                    action(LoginAction.OnValueChanged(PASSWORD_KEY, it))
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                action(LoginAction.Login)
            }) {
                Text(text = "Login")
            }
        }
    }
}