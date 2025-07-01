package dev.elsayed.caffeine.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CaffieneColors(
    val surfaceBackground: Color,
    val white: Color,
    val white87: Color,
    val black: Color,
    val textColor: Color,
    val titleColor: Color,
    val titleColor2: Color,
    val questionColorColor2: Color,
)

val lightThemeColors = CaffieneColors(
    surfaceBackground = Color(0xFFF5F5F5),
    white = Color(0xFFFFFFFF),
    white87 = Color(0xDEFFFFFF),
    black = Color(0xFF1F1F1F),
    textColor = Color(0xDE1F1F1F),
    titleColor = Color(0xFFB3B3B3),
    titleColor2 = Color(0xFF3B3B3B),
    questionColorColor2 = Color(0xCC1F1F1F),
)

val LocalColorTheme = staticCompositionLocalOf { lightThemeColors }