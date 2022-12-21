package com.example.base


sealed class Screens(val route: String) {
    object HomeScreen : Screens("main/home")
    object LoginScreen : Screens("main/login")
    object SignupScreen : Screens("main/signup")
    object ProfileScreen : Screens("main/profile")
    object MessageScreen : Screens("main/message?id={id}") {
        fun createRoute(id: String): String {
            return "main/message?id=$id"
        }
    }
}