package dev.elsayed.caffeine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.elsayed.caffeine.navigation.AppNavigation
import dev.elsayed.caffeine.ui.theme.CaffieneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaffieneTheme {
                AppNavigation()
            }
        }
    }
}