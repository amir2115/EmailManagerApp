package com.example.ui.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import collectAsState
import com.example.base.Screens
import com.example.base.Success
import com.example.common_compose.theme.WHITE_100
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

    if (viewState.loginResponse is Success) {
        navController.navigate(Screens.HomeScreen.route)
    }

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
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.secondary
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(textColor = MaterialTheme.colors.secondary),
                value = viewState.email,
                placeholder = {
                    Text(
                        text = "email",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.secondary
                    )
                },
                onValueChange = {
                    action(LoginAction.OnValueChanged(EMAIL_KEY, it))
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(textColor = MaterialTheme.colors.secondary),
                value = viewState.password,
                placeholder = {
                    Text(
                        text = "password",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.secondary
                    )
                },
                onValueChange = {
                    action(LoginAction.OnValueChanged(PASSWORD_KEY, it))
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    action(LoginAction.Login)
                }) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.body1,
                    color = WHITE_100
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        action(LoginAction.NavigateToScreen(Screens.SignupScreen.route))
                    }
            ) {
                Text(
                    text = "Don't have an account? Click to signup",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.secondary
                )
            }
        }
    }
}