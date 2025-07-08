package dev.elsayed.caffeine.interactions

import dev.elsayed.caffeine.state.CaffeineAmount
import dev.elsayed.caffeine.state.CupSize

interface MakerInteractions {
    fun onChangeCupSize(cupSize: CupSize)
    fun onChangeCaffeineAmount(amount: CaffeineAmount)
}