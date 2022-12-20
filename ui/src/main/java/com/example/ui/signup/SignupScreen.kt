package com.example.ui.signup

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
fun SignupScreen(navController: NavController) {
    SignupScreen(
        navController,
        hiltViewModel()
    )
}

@Composable
internal fun SignupScreen(
    navController: NavController,
    viewModel: SignupViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val viewState by viewModel.collectAsState()

    SignupScreen(
        scaffoldState = scaffoldState,
        viewState = viewState,
    ) { action ->
        when (action) {
            is SignupAction.NavigateToScreen -> navController.navigate(action.route)
            else -> viewModel.submitAction(action)
        }
    }
}

@Composable
internal fun SignupScreen(
    scaffoldState: ScaffoldState,
    viewState: SignupState,
    action: (SignupAction) -> Unit
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