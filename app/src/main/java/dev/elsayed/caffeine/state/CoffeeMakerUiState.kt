package dev.elsayed.caffeine.state

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.elsayed.caffeine.R

data class CoffeeMakerUiState(
    val caffeineAmount: CaffeineAmount = CaffeineAmount.LOW,
    val cupSize: CupSize = CupSize.M,
    val animationTriggerId: Int = 1,
    val reverseAnimationTriggerId: Int = 0,
    val hasBeansDropped: Boolean = true
)

enum class CaffeineAmount() {
    LOW(), MEDIUM(), HIGH()
}

enum class CupSize(
    val height: Dp,
    val width: Dp,
    val brandIconSize: Dp,
    val icon: Int,
    val volumeMl: String,
) {
    S(
        height = 188.dp,
        width = 153.64.dp,
        brandIconSize = 40.dp,
        icon = (R.drawable.the_chance_coffe_small),
        volumeMl = "150 ML"
    ),
    M(
        height = 244.dp,
        width = 199.4.dp,
        brandIconSize = 64.dp,
        icon = (R.drawable.the_chance_coffe_big),
        volumeMl = "200 ML"
    ),
    L(
        height = 300.dp,
        width = 245.17.dp,
        brandIconSize = 64.dp,
        icon = (R.drawable.the_chance_coffe_big),
        volumeMl = "400 ML"
    ),
}
