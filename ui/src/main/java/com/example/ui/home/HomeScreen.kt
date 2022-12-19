package com.example.ui.home

import android.annotation.SuppressLint
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
fun HomeScreen(navController: NavController) {
    HomeScreen(
        navController,
        hiltViewModel()
    )
}

@Composable
internal fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val viewState by viewModel.collectAsState()

    HomeScreen(
        scaffoldState = scaffoldState,
        viewState = viewState,
    ) { action ->
        when (action) {
            is HomeAction.NavigateToScreen -> navController.navigate(action.route)
            else -> viewModel.submitAction(action)
        }
    }
}

@Composable
internal fun HomeScreen(
    scaffoldState: ScaffoldState,
    viewState: HomeState,
    action: (HomeAction) -> Unit
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