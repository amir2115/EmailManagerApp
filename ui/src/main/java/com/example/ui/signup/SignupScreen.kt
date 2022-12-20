package com.example.ui.signup

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
        Column(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Signup")
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = viewState.email,
                onValueChange = {
                    action(SignupAction.OnValueChanged(SignupViewModel.EMAIL_KEY, it))
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = viewState.password,
                onValueChange = {
                    action(SignupAction.OnValueChanged(SignupViewModel.PASSWORD_KEY, it))
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                action(SignupAction.Signup)
            }) {
                Text(text = "Signup")
            }
        }
    }
}