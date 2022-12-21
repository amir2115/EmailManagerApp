package com.example.ui.profile

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import collectAsState
import com.example.base.Success
import com.example.ui.R
import com.example.ui.message.FixedSizeImage

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
            is ProfileAction.NavigateUp -> navController.navigateUp()
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
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FixedSizeImage(painterResource(R.drawable.ic_back)) {
                    action(ProfileAction.NavigateUp)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                modifier = Modifier.size(64.dp),
                painter = painterResource(R.drawable.profile_3),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(16.dp))
            AnimatedVisibility(viewState.profileResponse is Success) {
                viewState.profileResponse()?.let {
                    Text(
                        text = "address: ${it.address}",
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.secondary,
                    )
                }
            }
        }
    }
}