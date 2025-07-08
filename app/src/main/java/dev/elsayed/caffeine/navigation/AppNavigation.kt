package dev.elsayed.caffeine.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dev.elsayed.caffeine.screens.CaffeineSliderScreen
import dev.elsayed.caffeine.screens.CoffeeLineFinishScreen
import dev.elsayed.caffeine.screens.CoffeeMakerScreen
import dev.elsayed.caffeine.screens.CoffeeReadyScreen
import dev.elsayed.caffeine.screens.SweetsSnackScreen
import dev.elsayed.caffeine.screens.TakeYourSweetScreen
import dev.elsayed.caffeine.screens.WelcomeScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = WelcomeScreen) {
        composable<WelcomeScreen> { WelcomeScreen(navController = navController) }
        composable<CaffeineSliderScreen> { CaffeineSliderScreen(navController = navController) }
        composable<CoffeeMakerScreen> { CoffeeMakerScreen(navController = navController) }
        composable<CoffeeLineFinishScreen> { CoffeeLineFinishScreen(navController = navController) }
        composable<CoffeeReadyScreen> { CoffeeReadyScreen(navController = navController) }
        composable<TakeYourSweetScreen> { TakeYourSweetScreen(navController = navController) }
        composable<SnackScreen> { it ->
            val args = it.toRoute<SnackScreen>()
            SweetsSnackScreen(sweatResId = args.sweatResId, navController = navController)
        }
    }

}
