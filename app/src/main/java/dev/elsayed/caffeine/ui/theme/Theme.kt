package dev.elsayed.caffeine.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object Theme {
    val colors: CaffieneColors
        @Composable @ReadOnlyComposable get() = LocalColorTheme.current
}