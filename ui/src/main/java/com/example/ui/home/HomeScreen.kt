package com.example.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import collectAsState
import com.example.base.Screens
import com.example.common_compose.component.coloredShadow
import com.example.domain.model.message.HydraMember
import com.example.ui.R
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch

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
    val scope = rememberCoroutineScope()
    val viewState by viewModel.collectAsState()

    HomeScreen(
        scaffoldState = scaffoldState,
        viewState = viewState,
    ) { action ->
        when (action) {
            is HomeAction.NavigateToScreen -> navController.navigate(action.route)
            is HomeAction.OpenDrawer -> scope.launch {
                scaffoldState.drawerState.open()
            }
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
        drawerContent = {
            DrawerContent(action)
        },
        backgroundColor = MaterialTheme.colors.background
    ) {
        SwipeRefresh(
            state = rememberSwipeRefreshState(viewState.isRefreshing),
            onRefresh = { action(HomeAction.Refresh) },
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
                    Image(
                        modifier = Modifier.clickable { action(HomeAction.OpenDrawer) },
                        painter = painterResource(R.drawable.ic_menu),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Search in mail",
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.secondary,
                        modifier = Modifier.weight(1F)
                    )
                    Image(
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { action(HomeAction.NavigateToScreen(Screens.ProfileScreen.route)) },
                        painter = painterResource(R.drawable.profile_2),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "PRIMARY",
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Medium),
                    color = MaterialTheme.colors.secondary
                )
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
}

@Composable
private fun DrawerContent(action: (HomeAction) -> Unit) {
    LazyColumn {
        item {
            Card(
                elevation = 4.dp,
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(1.dp, color = Color.Gray.copy(alpha = 0.1F)),
            ) {
                Text(
                    text = "Email Manager",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.secondary,
                    modifier = Modifier.padding(24.dp)
                )
            }
        }
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { action(HomeAction.Logout) }
                    .padding(horizontal = 16.dp, vertical = 12.dp),
            ) {
                IconButton(onClick = { action(HomeAction.Logout) }) {
                    Icon(
                        imageVector = Icons.Filled.ExitToApp,
                        contentDescription = null,
                        tint = MaterialTheme.colors.secondary
                    )
                }
                Text(
                    text = "Logout",
                    fontSize = 12.sp,
                    color = MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 8.dp),
                )
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
        Image(
            modifier = Modifier.size(36.dp),
            painter = painterResource(R.drawable.profile_3),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1F)) {
            Text(
                text = hydraMember.subject,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.secondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = hydraMember.intro,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.secondary
            )
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "11:27 pm",
                style = MaterialTheme.typography.overline,
                color = MaterialTheme.colors.secondary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                modifier = Modifier.size(16.dp),
                painter = painterResource(R.drawable.ic_star_filled),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color(0xFFFBBC05)),
            )
        }
    }
}