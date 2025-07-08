package dev.elsayed.caffeine.navigation

import kotlinx.serialization.Serializable

@Serializable
object WelcomeScreen

@Serializable
object CaffeineSliderScreen

@Serializable
object CoffeeMakerScreen

@Serializable
object CoffeeLineFinishScreen

@Serializable
object CoffeeReadyScreen

@Serializable
object TakeYourSweetScreen

@Serializable
data class SnackScreen(val sweatResId: Int)