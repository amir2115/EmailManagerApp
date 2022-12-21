package com.example.emailmanagerapp.main

import LocalBackPressedDispatcher
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import collectAsState
import com.example.base.Screens
import com.example.common_compose.theme.EmailManagerTheme
import com.example.domain.preferences.PreferencesStorage
import com.example.emailmanagerapp.navigation.AppNavigation
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var preferencesStorage: PreferencesStorage

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberAnimatedNavController()
            val viewState by viewModel.collectAsState()
            val token = preferencesStorage.observableToken.collectAsState(viewState.token)

            EmailManagerTheme {
                CompositionLocalProvider(
                    LocalBackPressedDispatcher provides onBackPressedDispatcher
                ) {
                    LaunchedEffect(token.value) {
                        if (token.value.isEmpty()) {
                            delay(200)
                            navController.navigate(Screens.LoginScreen.route)
                        }
                    }
                    val startDestination = if (viewState.token.isNotEmpty()) {
                        Screens.HomeScreen.route
                    } else {
                        Screens.LoginScreen.route
                    }
                    AppNavigation(navController, startDestination)
                }
            }
        }
    }
}