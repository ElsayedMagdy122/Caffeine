package dev.elsayed.caffeine.screens

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInCubic
import androidx.compose.animation.core.EaseOutCubic
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.elsayed.caffeine.navigation.CaffeineSliderScreen
import dev.elsayed.caffeine.navigation.CoffeeLineFinishScreen
import dev.elsayed.caffeine.R
import dev.elsayed.caffeine.composable.CaffeineButton
import dev.elsayed.caffeine.composable.CoffeeCupSizeOptions
import dev.elsayed.caffeine.composable.CoffeePercentageCaffeineOptions
import dev.elsayed.caffeine.composable.DetailsAppBar
import dev.elsayed.caffeine.state.CoffeeMakerUiState
import dev.elsayed.caffeine.state.CupSize
import dev.elsayed.caffeine.ui.theme.Theme
import dev.elsayed.caffeine.ui.theme.Urbanist
import dev.elsayed.caffeine.viewmodel.CoffeeMakerViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import kotlin.math.roundToInt


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun CoffeeMakerScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    coffeeMakerViewModel: CoffeeMakerViewModel = koinViewModel()
) {
    val state by coffeeMakerViewModel.state.collectAsState()
    val animatedCupHeight by animateDpAsState(
        targetValue = state.cupSize.height,
        animationSpec = tween(durationMillis = 600, easing = LinearEasing),
        label = "CupHeight"
    )

    val animatedCupWidth by animateDpAsState(
        targetValue = state.cupSize.width,
        animationSpec = tween(durationMillis = 600, easing = LinearEasing),
        label = "CupWidth"
    )

    val animatedBrandLogoSize by animateDpAsState(
        targetValue = state.cupSize.brandIconSize,
        animationSpec = tween(durationMillis = 600, easing = LinearEasing),
        label = "CupWidth"
    )
    val bottomOffset = remember { Animatable(300f) } // يبدأ تحت الشاشة

    val hasTriggeredInitialDrop = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        bottomOffset.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 600)
        )
        if (state.hasBeansDropped) {
            hasTriggeredInitialDrop.value = true
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.white)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            DetailsAppBar(onNavClick = {
                navController.navigate(CaffeineSliderScreen)
            }, modifier = Modifier.offset(y= bottomOffset.value.dp))

            Box(
                modifier = modifier
                    .height(341.dp)
                    .fillMaxWidth()
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    // .zIndex(1f),
                    contentAlignment = Alignment.TopCenter
                ) {
                    if (!state.hasBeansDropped) {
                        FallingCoffeeBeans(
                            state = state,
                            isReversed = true,
                            onAnimationEnd = {}
                        )
                    } else {
                        FallingCoffeeBeans(
                            state = state,
                            isReversed = false
                        )
                    }
                }
                Image(
                    modifier = Modifier
                        // .padding(horizontal = 80.dp, vertical = 48.dp)
                        .height(animatedCupHeight)
                        .width(animatedCupWidth)
                        .align(Alignment.Center),
                    painter = painterResource(R.drawable.empty_cup_coffee),
                    contentDescription = null
                )

                Image(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(animatedBrandLogoSize),

                    painter = painterResource(state.cupSize.icon),
                    contentDescription = null
                )

                @OptIn(ExperimentalAnimationApi::class)
                AnimatedContent(
                    targetState = state.cupSize.volumeMl,
                    transitionSpec = {
                        // إلغاء كل الأنميشنات
                        (fadeIn(animationSpec = tween(0))) with fadeOut(animationSpec = tween(0))
                    },
                    label = "SmoothTextChange"
                ) { volumeText ->
                    Text(
                        text = volumeText,
                        fontFamily = Urbanist,
                        fontSize = 14.sp,
                        color = Theme.colors.mlText,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(top = 64.dp, start = 16.dp)
                    )
                }

            }
            CoffeeCupSizeOptions(
                selectedCupSize = state.cupSize,
                onChangeCupSize = coffeeMakerViewModel::onChangeCupSize
            )
            CoffeePercentageCaffeineOptions(
                selectedCaffeineAmount = state.caffeineAmount,
                onChangeCaffeineAmount = coffeeMakerViewModel::onChangeCaffeineAmount
            )

        }

        CaffeineButton(
            text = "Continue",
            icon = ImageVector.vectorResource(R.drawable.arrow_right_ic),
            onNavClick = {
                navController.navigate(CoffeeLineFinishScreen)
            },
            modifier = Modifier
                .width(162.dp)
                .offset(y= bottomOffset.value.dp)
                .align(Alignment.BottomCenter)

        )


    }
}
@Composable
fun FallingCoffeeBeans(
    modifier: Modifier = Modifier,
    onAnimationEnd: () -> Unit = {},
    state: CoffeeMakerUiState,
    isReversed: Boolean = false
) {
    val density = LocalDensity.current
    val screenHeightPx = with(density) { LocalConfiguration.current.screenHeightDp.dp.toPx() }

    val offsetY = remember { Animatable(0f) }
    val scale = remember { Animatable(1.5f) }
    val alpha = remember { Animatable(0f) }

    val targetY = 100f
    val startScale = 1.8f
    val endScale = when (state.cupSize) {
        CupSize.S -> 0.5f
        CupSize.M -> 0.6f
        CupSize.L -> 0.7f
    }

    val dropDuration = when (state.cupSize) {
        CupSize.S -> 1200
        CupSize.M -> 1000
        CupSize.L -> 1000
    }
    val scaleDuration = dropDuration - 100

    val launchKey = if (isReversed) state.reverseAnimationTriggerId else state.animationTriggerId

    val shouldAnimate = if (isReversed) {
        state.reverseAnimationTriggerId > 0
    } else {
        state.animationTriggerId > 0 || !state.hasBeansDropped
    }

    LaunchedEffect(launchKey) {
        if (!shouldAnimate) return@LaunchedEffect

        if (!isReversed) {
            offsetY.snapTo(-screenHeightPx)
            scale.snapTo(startScale)
            alpha.snapTo(1f)

            launch {
                offsetY.animateTo(
                    targetValue = targetY,
                    animationSpec = tween(durationMillis = dropDuration, easing = EaseInCubic)
                )
            }

            launch {
                scale.animateTo(
                    targetValue = endScale,
                    animationSpec = tween(durationMillis = scaleDuration, easing = EaseOutCubic)
                )
            }

            launch {
                delay(dropDuration.toLong())
                alpha.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 300)
                )
                onAnimationEnd()
            }
        } else {
            offsetY.snapTo(targetY)
            scale.snapTo(endScale)
            alpha.snapTo(1f)

            launch {
                offsetY.animateTo(
                    targetValue = -screenHeightPx,
                    animationSpec = tween(durationMillis = 1400, easing = EaseOutCubic)
                )
            }

            launch {
                scale.animateTo(
                    targetValue = startScale,
                    animationSpec = tween(durationMillis = 1300, easing = EaseInCubic)
                )
            }

            launch {
                delay(1300)
                alpha.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 300)
                )
                onAnimationEnd()
            }
        }
    }
    if (alpha.value > 0f) {
        Image(
            painter = painterResource(R.drawable.coffe),
            contentDescription = "Falling Coffee Bean",
            modifier = modifier
                .graphicsLayer(
                    scaleX = scale.value,
                    scaleY = scale.value,
                    alpha = alpha.value
                )
                .offset { IntOffset(x = 0, y = offsetY.value.roundToInt()) }
        )
    }
}


@Preview(device = "spec:width=360dp,height=800dp", showSystemUi = true)
@Composable
fun CoffeeMakerScreenPrev(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    CoffeeMakerScreen(navController = navController)
}
