package com.example.ui.message

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
fun MessageScreen(navController: NavController) {
    MessageScreen(
        navController,
        hiltViewModel()
    )
}

@Composable
internal fun MessageScreen(
    navController: NavController,
    viewModel: MessageViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val viewState by viewModel.collectAsState()

    MessageScreen(
        scaffoldState = scaffoldState,
        viewState = viewState,
    ) { action ->
        when (action) {
            is MessageAction.NavigateToScreen -> navController.navigate(action.route)
            else -> viewModel.submitAction(action)
        }
    }
}

@Composable
internal fun MessageScreen(
    scaffoldState: ScaffoldState,
    viewState: MessageState,
    action: (MessageAction) -> Unit
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