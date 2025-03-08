package com.examples.myfirstapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val BluePrimary = Color(0xFF0070F3)
val BlueHover = Color(0xFF005BB5)
val InputBorder = Color(0xFFCCCCCC)
val ErrorColor = Color(0xFFFF0000)
val BackgroundColor = Color(0xFFF5F5F5)

private val LightColorScheme = lightColorScheme(
    primary = BluePrimary,
    secondary = BlueHover,
    error = ErrorColor,
    background = BackgroundColor,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val colors = if (isSystemInDarkTheme()) LightColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
