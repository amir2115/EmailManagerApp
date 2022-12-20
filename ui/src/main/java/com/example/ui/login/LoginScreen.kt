package com.example.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import collectAsState

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
        Column(modifier = Modifier.padding(it)) {
            Text(text = "Hi")
        }
    }
}