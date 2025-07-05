package dev.elsayed.caffeine.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.elsayed.caffeine.R
import dev.elsayed.caffeine.composable.CaffeineButton
import dev.elsayed.caffeine.composable.DetailsAppBar
import dev.elsayed.caffeine.composable.dropShadow
import dev.elsayed.caffeine.ui.theme.Theme
import dev.elsayed.caffeine.ui.theme.Urbanist


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun CoffeeMakerScreen(
    modifier: Modifier = Modifier,

    ) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.white)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DetailsAppBar()
            Box(
                modifier = modifier
                    .height(341.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier
                        .padding(horizontal = 80.dp, vertical = 48.dp)
                        .height(341.dp)
                        .width(200.dp)
                        .align(Alignment.TopCenter),
                    painter = painterResource(R.drawable.black),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(64.dp),
                    painter = painterResource(R.drawable.the_chance_coffe_big),
                    contentDescription = null
                )
                Text(
                    text = "200 Ml",
                    fontFamily = Urbanist,
                    fontSize = 14.sp,
                    color = Theme.colors.mlText,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 64.dp, start = 16.dp)
                )

            }
            CoffeeCupSizeOptions()
            CoffeePercentageCaffeineOptions()

        }
        CaffeineButton(
            text = "Continue",
            icon = ImageVector.vectorResource(R.drawable.arrow_right_ic),
            modifier = Modifier
                .width(162.dp)
                .align(Alignment.BottomCenter)

        )
    }
}

@Composable
fun CoffeeCupSizeOptions() {
    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(56.dp)
            .width(152.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(Color(0xFFF5F5F5)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        CircleSizeOption(textSize = "S")
        CircleSizeOption(optionClicked = true, textSize = "M")
        CircleSizeOption(textSize = "L")
    }
}

@Composable
fun CoffeePercentageCaffeineOptions() {
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .width(152.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(Color(0xFFF5F5F5)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CircleCaffeineOption(textSize = "S")
            CircleCaffeineOption(textSize = "M")
            CircleCaffeineOption(optionClicked = true, textSize = "L")
        }
        Row(
            modifier = Modifier
                .padding(top = 2.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val textColor = Color(0x991F1F1F)
            Text(
                text = "Low",
                fontFamily = Urbanist,
                fontSize = 10.sp,
                color = textColor,
                fontWeight = FontWeight.Medium,

                )
            Text(
                text = "Medium",
                fontFamily = Urbanist,
                fontSize = 10.sp,
                color = textColor,
                fontWeight = FontWeight.Medium,

                )
            Text(
                text = "High",
                fontFamily = Urbanist,
                fontSize = 10.sp,
                color = textColor,
                fontWeight = FontWeight.Medium,

                )
        }
    }

}

@Composable
fun CircleSizeOption(
    modifier: Modifier = Modifier, optionClicked: Boolean = false, textSize: String = "S"
) {
    Column(
        modifier = modifier
            .size(40.dp)
            .then(
                if (optionClicked) {
                    Modifier.dropShadow(
                        CircleShape,
                        color = Color(0x80B94B23),
                        offsetY = 6.dp,
                        offsetX = 0.dp,
                        blur = 16.dp,
                    )
                } else Modifier
            )
            .clip(CircleShape)
            .then(
                if (optionClicked) {
                    Modifier.background(Color(0xFF7C351B))
                } else Modifier.background(Color.Transparent)
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val textColor =
            if (optionClicked) Color(0xFFFFFFFF).copy(alpha = 0.87f) else Color(0xFF1F1F1F).copy(
                alpha = 0.60f
            )
        Text(
            text = textSize,
            fontFamily = Urbanist,
            fontSize = 20.sp,
            color = textColor,
            fontWeight = FontWeight.Bold,

            )
    }
}

@Composable
fun CircleCaffeineOption(
    modifier: Modifier = Modifier, optionClicked: Boolean = false, textSize: String = "S"
) {
    Column(
        modifier = modifier
            .size(40.dp)
            .then(
                if (optionClicked) {
                    Modifier.dropShadow(
                        CircleShape,
                        color = Color(0x80B94B23),
                        offsetY = 6.dp,
                        offsetX = 0.dp,
                        blur = 16.dp,
                    )
                } else Modifier
            )
            .clip(CircleShape)
            .then(
                if (optionClicked) {
                    Modifier.background(Color(0xFF7C351B))
                } else Modifier.background(Color.Transparent)
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (optionClicked) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.coffee_beans),
                contentDescription = null, tint = Color.Unspecified
            )
        }
    }
}


@Preview(device = "spec:width=360dp,height=800dp", showSystemUi = true)
@Composable
fun CoffeeMakerScreenPrev(modifier: Modifier = Modifier) {
    CoffeeMakerScreen()
}

//
//fun Modifier.circleShadow(
//    alpha: Float,
//    isSelected: Boolean,
//    shadowColor: Color,
//    shadowRadius: Float = 24f,
//    offsetX: Float = 0f,
//    offsetY: Float = 12f,
//    circleSizeRatio: Float = 1.7f
//): Modifier = this.drawWithCache {
//    onDrawWithContent {
//        if (isSelected && alpha > 0f) {
//            drawIntoCanvas { canvas ->
//                canvas.nativeCanvas.drawCircle(
//                    size.width / 2,
//                    size.height / 2,
//                    size.minDimension / circleSizeRatio,
//                    Paint().apply {
//                        color = android.graphics.Color.TRANSPARENT
//                        setShadowLayer(
//                            shadowRadius, offsetX, offsetY, shadowColor.toArgb()
//                        )
//                    }
//                )
//            }
//        }
//        drawContent()
//    }
//}
//
//enum class CoffeeIntensity(val volume: Short) {
//    LOW(30), MEDIUM(60), HIGH(90)
//}
//
//enum class CupSize(
//    val height: Dp,
//    val width: Dp,
//    val iconSize: Dp,
//    val volumeMl: String,
//) {
//    S(height = 200.dp, width = 40.dp, iconSize = 40.dp, volumeMl = "150 ml"),
//    M(height = 250.dp, width = 66.dp, iconSize = 66.dp, volumeMl = "200 ml"),
//    L(height = 300.dp, width = 66.dp, iconSize = 66.dp, volumeMl = "400 ml"),
//}
//
//data class CustomizationCoffeeUiState(
//    val sizeSelected: CupSize = CupSize.M,
//    val intensitySelected: CoffeeIntensity = CoffeeIntensity.LOW,
//    val continueEnabled: Boolean = true
//)
//
//interface CustomizationCoffeeInteractions {
//    fun onSizeSelected(size: CupSize)
//    fun onIntensitySelected(intensity: CoffeeIntensity)
//    fun onContinueClicked()
//}
//
//class CustomizationCoffeeViewModel : ViewModel(), CustomizationCoffeeInteractions {
//    private val _uiState = MutableStateFlow(CustomizationCoffeeUiState())
//    val uiState: StateFlow<CustomizationCoffeeUiState> = _uiState.asStateFlow()
//    override fun onSizeSelected(size: CupSize) {
//        _uiState.value = _uiState.value.copy(sizeSelected = size)
//    }
//
//    override fun onIntensitySelected(intensity: CoffeeIntensity) {
//        _uiState.value = _uiState.value.copy(intensitySelected = intensity)
//    }
//
//    override fun onContinueClicked() {
//        _uiState.value = _uiState.value.copy(continueEnabled = _uiState.value.continueEnabled.not())
//    }
//}