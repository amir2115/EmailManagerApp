package com.example.emailmanagerapp

import LocalBackPressedDispatcher
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.CompositionLocalProvider
import com.example.common_compose.theme.EmailManagerTheme
import com.example.emailmanagerapp.navigation.AppNavigation
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberAnimatedNavController()
            EmailManagerTheme {
                CompositionLocalProvider(
                    LocalBackPressedDispatcher provides onBackPressedDispatcher
                ) {
                    AppNavigation(navController)
                }
            }
        }
    }
}