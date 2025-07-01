package dev.elsayed.caffeine.ui.theme

import androidx.activity.ComponentActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat

@Composable
fun CaffieneTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    UpdateStatusBarIconsForTheme(darkTheme = false)
    val theme = if (darkTheme) lightThemeColors else lightThemeColors
    CompositionLocalProvider(
        LocalColorTheme provides theme,
    ) {
        content()
    }
}

@Composable
private fun UpdateStatusBarIconsForTheme(darkTheme: Boolean) {
    val isDarkIcons = !darkTheme
    val view = LocalView.current
    val window = (view.context as? ComponentActivity)?.window ?: return
    WindowInsetsControllerCompat(window, view).apply {
        isAppearanceLightStatusBars = isDarkIcons
    }
}