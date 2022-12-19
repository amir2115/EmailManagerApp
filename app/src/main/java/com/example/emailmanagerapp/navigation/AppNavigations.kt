package com.example.emailmanagerapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.base.Screens
import com.google.accompanist.navigation.animation.AnimatedNavHost

@ExperimentalAnimationApi
@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: String = Screens.HomeScreen.route,
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = MAIN_NAV_GRAPH_ROUTE,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() },
        popEnterTransition = { fadeIn() },
        popExitTransition = { fadeOut() },
        modifier = Modifier,
    ) {
        mainNavGraph(startDestination, navController)
    }
}