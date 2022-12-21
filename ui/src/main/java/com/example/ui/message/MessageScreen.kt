package com.example.ui.message

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import collectAsState
import com.example.base.Success
import com.example.ui.R

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
            is MessageAction.NavigateUp -> navController.navigateUp()
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FixedSizeImage(painterResource(R.drawable.ic_back)) {
                    action(MessageAction.NavigateUp)
                }
                Spacer(modifier = Modifier.weight(1F))
                FixedSizeImage(painterResource(R.drawable.ic_receive))
                FixedSizeImage(painterResource(R.drawable.ic_remove)) {
                    action(MessageAction.Delete)
                }
                FixedSizeImage(painterResource(R.drawable.ic_mail))
                FixedSizeImage(painterResource(R.drawable.ic_more))
            }
            Spacer(modifier = Modifier.height(16.dp))
            AnimatedVisibility(visible = viewState.messageResponse is Success) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = viewState.messageResponse()?.subject ?: "",
                        style = MaterialTheme.typography.h4,
                        color = MaterialTheme.colors.secondary,
                        modifier = Modifier.weight(1F)
                    )
                    Image(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(R.drawable.ic_start),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}

@Composable
internal fun FixedSizeImage(painter: Painter, onClick: (() -> Unit)? = null) {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .size(24.dp)
            .clickable { onClick?.invoke() }
    ) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painter,
            contentDescription = null
        )
    }
}