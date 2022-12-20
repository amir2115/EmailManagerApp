package com.example.base


sealed class Screens(val route : String) {
    object HomeScreen : Screens("main/home")
    object LoginScreen : Screens("main/login")
    object SignupScreen : Screens("main/signup")
    object MessageScreen : Screens("main/message")
}