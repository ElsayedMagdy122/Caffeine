package dev.elsayed.caffeine.viewmodel

import androidx.lifecycle.ViewModel
import dev.elsayed.caffeine.interactions.MakerInteractions
import dev.elsayed.caffeine.state.CaffeineAmount
import dev.elsayed.caffeine.state.CoffeeMakerUiState
import dev.elsayed.caffeine.state.CupSize
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CoffeeMakerViewModel : ViewModel(), MakerInteractions {
    private val _state = MutableStateFlow(CoffeeMakerUiState())
    val state: StateFlow<CoffeeMakerUiState> = _state.asStateFlow()
    override fun onChangeCupSize(cupSize: CupSize) {
        _state.update {
            if (it.hasBeansDropped) {
                it.copy(
                    cupSize = cupSize,
                    reverseAnimationTriggerId = it.reverseAnimationTriggerId + 1,
                    hasBeansDropped = false,
                     caffeineAmount = CaffeineAmount.LOW
                )
            } else {

                it.copy(cupSize = cupSize,  hasBeansDropped = false)
            }
        }
    }

    override fun onChangeCaffeineAmount(amount: CaffeineAmount) {
        _state.update {
            it.copy(
                caffeineAmount = amount,
                animationTriggerId = it.animationTriggerId + 1,
                hasBeansDropped = true
            )
        }
    }

}