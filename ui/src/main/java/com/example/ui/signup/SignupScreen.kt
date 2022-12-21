package com.example.ui.signup

import androidx.compose.animation.AnimatedVisibility
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

    if (viewState.signupResponse is Success) {
        navController.navigate(
            Screens.LoginScreen.createRoute(
                "${viewState.email}@${viewState.domain}",
                viewState.password
            )
        )
    }

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
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Signup",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.secondary
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewState.email,
                colors = TextFieldDefaults.textFieldColors(textColor = MaterialTheme.colors.secondary),
                placeholder = {
                    Text(
                        text = "email",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.secondary
                    )
                },
                trailingIcon = {
                    AnimatedVisibility(viewState.domain.isNotEmpty()) {
                        Text(
                            text = "@${viewState.domain}",
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.secondary,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                },
                onValueChange = {
                    action(SignupAction.OnValueChanged(SignupViewModel.EMAIL_KEY, it))
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
                    action(SignupAction.OnValueChanged(SignupViewModel.PASSWORD_KEY, it))
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    action(SignupAction.Signup)
                }) {
                Text(
                    text = "Signup",
                    style = MaterialTheme.typography.body1,
                    color = WHITE_100
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        action(SignupAction.NavigateToScreen(Screens.LoginScreen.route))
                    }
            ) {
                Text(
                    text = "Already have an account? Click to login",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.secondary
                )
            }
        }
    }
}