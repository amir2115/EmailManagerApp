package com.example.base


sealed class Screens(val route : String) {
    object HomeScreen : Screens("main/home-screen")
}