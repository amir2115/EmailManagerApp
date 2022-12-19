package com.example.emailmanagerapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.base.Screens
import com.example.ui.home.HomeScreen
import com.google.accompanist.navigation.animation.composable

const val MAIN_NAV_GRAPH_ROUTE = "main"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.mainNavGraph(
    startDestination: String,
    navController: NavController
) {

    navigation(startDestination = startDestination, route = MAIN_NAV_GRAPH_ROUTE) {
        composable(Screens.HomeScreen.route) {
            HomeScreen(navController)
        }
    }
}