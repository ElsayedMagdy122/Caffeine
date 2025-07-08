package dev.elsayed.caffeine.di

import dev.elsayed.caffeine.viewmodel.CoffeeMakerViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::CoffeeMakerViewModel)
}