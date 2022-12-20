package com.example.ui.profile

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
fun ProfileScreen(navController: NavController) {
    ProfileScreen(
        navController,
        hiltViewModel()
    )
}

@Composable
internal fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val viewState by viewModel.collectAsState()

    ProfileScreen(
        scaffoldState = scaffoldState,
        viewState = viewState,
    ) { action ->
        when (action) {
            is ProfileAction.NavigateToScreen -> navController.navigate(action.route)
            else -> viewModel.submitAction(action)
        }
    }
}

@Composable
internal fun ProfileScreen(
    scaffoldState: ScaffoldState,
    viewState: ProfileState,
    action: (ProfileAction) -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Profile")
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}