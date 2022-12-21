package com.example.emailmanagerapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.*
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
        composable(
            route = Screens.LoginScreen.route,
            arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument("password") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            LoginScreen(navController)
        }
        composable(Screens.SignupScreen.route) {
            SignupScreen(navController)
        }
        composable(
            route = Screens.MessageScreen.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            MessageScreen(navController)
        }
        composable(Screens.ProfileScreen.route) {
            ProfileScreen(navController)
        }
    }
}