package com.example.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import collectAsState
import com.example.base.Screens
import com.example.common_compose.component.coloredShadow
import com.example.common_compose.theme.PRIMARY_COLOR100
import com.example.domain.model.message.HydraMember
import com.example.ui.R

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp)
                    .coloredShadow(
                        color = Color.Black,
                        alpha = 0.1F
                    )
                    .background(Color.White, RoundedCornerShape(8.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(12.dp))
                Image(painter = painterResource(R.drawable.ic_menu), contentDescription = null)
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Search in mail",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.secondary,
                    modifier = Modifier.weight(1F)
                )
                Image(painter = painterResource(R.drawable.ic_menu), contentDescription = null)
                Spacer(modifier = Modifier.width(12.dp))
            }
            Spacer(modifier = Modifier.height(12.dp))
            viewState.messagesResponse()?.let { messages ->
                LazyColumn(
                    state = rememberLazyListState(),
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                ) {
                    items(messages.member) { item ->
                        MessageItem(item) {
                            action(
                                HomeAction.NavigateToScreen(
                                    Screens.MessageScreen.createRoute(
                                        item.id
                                    )
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MessageItem(hydraMember: HydraMember, action: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { action() },
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(PRIMARY_COLOR100, CircleShape)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1F)) {
            Text(
                text = hydraMember.subject,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.secondary
            )
            Text(
                text = hydraMember.intro,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.secondary
            )
        }
        Text(
            text = "11:27 pm",
            style = MaterialTheme.typography.overline,
            color = MaterialTheme.colors.secondary
        )
    }
}