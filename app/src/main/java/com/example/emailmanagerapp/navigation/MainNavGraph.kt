package com.example.emailmanagerapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.base.Screens
import com.example.ui.home.HomeScreen
import com.example.ui.login.LoginScreen
import com.example.ui.message.MessageScreen
import com.example.ui.profile.ProfileScreen
import com.example.ui.signup.SignupScreen
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
        composable(Screens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(Screens.SignupScreen.route) {
            SignupScreen(navController)
        }
        composable(Screens.MessageScreen.route) {
            MessageScreen(navController)
        }
        composable(Screens.ProfileScreen.route) {
            ProfileScreen(navController)
        }
    }
}