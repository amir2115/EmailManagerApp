package com.example.common_compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.ompfinex.app.common_ui_compose.theme.Shapes

private val DarkColorPalette = darkColors(
    primary = PRIMARY_COLOR600,
    onPrimary = PRIMARY_COLOR300,
    secondary = WHITE_100,
    onSecondary = WHITE_70,
    error = ERROR_COLOR800,
    onError = Success_COLOR900,
    background = BASIC_COLOR1000,
    onBackground = BASIC_COLOR1100,
    surface = BASIC_COLOR900,
    onSurface = BASIC_COLOR800,
)

private val LightColorPalette = lightColors(
    primary = LIGHT_PRIMARY_COLOR600,
    onPrimary = LIGHT_PRIMARY_COLOR300,
    secondary = LIGHT_WHITE_100,
    onSecondary = LIGHT_WHITE_70,
    error = LIGHT_ERROR_COLOR800,
    onError = LIGHT_Success_COLOR900,
    background = LIGHT_BASIC_COLOR1000,
    onBackground = LIGHT_BASIC_COLOR1100,
    surface = BASIC_COLOR10,
    onSurface = LIGHT_BASIC_COLOR800,
)

@Composable
fun EmailManagerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}