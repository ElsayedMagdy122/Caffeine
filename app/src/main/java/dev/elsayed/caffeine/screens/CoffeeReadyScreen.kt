package dev.elsayed.caffeine.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.elsayed.caffeine.R
import dev.elsayed.caffeine.navigation.TakeYourSweetScreen
import dev.elsayed.caffeine.composable.CaffeineButton
import dev.elsayed.caffeine.composable.CustomIconButton
import dev.elsayed.caffeine.ui.theme.CaffieneTheme
import dev.elsayed.caffeine.ui.theme.Theme
import dev.elsayed.caffeine.ui.theme.Urbanist

@Composable
fun CoffeeReadyScreen(modifier: Modifier = Modifier, navController: NavController) {
    CaffieneTheme {
        val topOffset = remember { Animatable(-300f) }
        LaunchedEffect(Unit) {
            topOffset.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 600)
            )
        }

        Box(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.navigationBars)
                .fillMaxSize()
                .background(Theme.colors.white)
        ) {
            val bottomOffset = remember { Animatable(300f) }
            LaunchedEffect(Unit) {
                bottomOffset.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 600)
                )
            }
            Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                TakeAwaySwitch(
                    modifier = Modifier

                        .padding(bottom = 16.dp)
                )
                CaffeineButton(
                    text = "Take snack",
                    icon = ImageVector.vectorResource(R.drawable.arrow_right_ic),
                    onNavClick = { navController.navigate(TakeYourSweetScreen) },
                    modifier = Modifier
                        .offset(y = bottomOffset.value.dp)
                        .width(180.dp)

                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()

                    .windowInsetsPadding(WindowInsets.statusBars),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = topOffset.value.dp)
                ) {
                    CustomIconButton(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp),
                        buttonSize = 48.dp,
                        iconRes = R.drawable.cancel_01,
                        contentDescription = null,
                        isDropShadow = false,
                        backgroundColor = Theme.colors.surfaceBackground,
                        onClick = { navController.popBackStack() }
                    )
                }

                CupCoffeeReady(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .offset(y = topOffset.value.dp)
                )
                CupCoffeeWithCover(
                    modifier = Modifier
                        .padding(top = 17.dp)
                        .height(341.dp)
                        .fillMaxWidth()
                )

            }


        }
    }
}

@Composable
fun TakeAwaySwitch(modifier: Modifier = Modifier) {
    var isOn by remember { mutableStateOf(false) }

    val animationDuration = 300

    val backgroundColor by animateColorAsState(
        targetValue = if (isOn) Color(0xFF7C351B) else Color(0xFFFFEEE7),
        animationSpec = tween(durationMillis = animationDuration)
    )
    val textColor by animateColorAsState(
        targetValue = if (isOn) Color(0x99FFFFFF) else Color(0x99000000),
        animationSpec = tween(durationMillis = animationDuration)
    )

    val offsetX by animateDpAsState(
        targetValue = if (isOn) 36.dp else 0.dp,
        animationSpec = tween(durationMillis = animationDuration)
    )

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(40.dp)
                .width(76.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(backgroundColor)
                .clickable { isOn = !isOn }
        ) {
            if (isOn) {
                Text(
                    text = "ON",
                    fontSize = 10.sp,
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 14.dp)
                )
            } else {
                Text(
                    text = "OFF",
                    fontSize = 10.sp,
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 14.dp)
                )
            }
            Icon(
                painter = painterResource(R.drawable.coffee_circle),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .offset(x = offsetX)
                    .size(40.dp)
            )
        }
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = "Take Away",
            fontFamily = Urbanist,
            fontSize = 22.sp,
            color = Theme.colors.textColor,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CupCoffeeReady(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        CustomIconButton(
            buttonSize = 56.dp,
            iconRes = R.drawable.tick_02,
            contentDescription = null,
            isDropShadow = true,
            backgroundColor = Color(0xFF7C351B),
            onClick = { }
        )
        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = "Your coffee is ready\n" +
                    "Enjoy",
            fontFamily = Urbanist,
            fontSize = 22.sp,
            color = Theme.colors.textColor,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun CupCoffeeWithCover(modifier: Modifier = Modifier) {
    val offsetY = remember { Animatable(-200f) } // يبدأ فوق
    LaunchedEffect(Unit) {
        offsetY.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 800)
        )
    }

    Box(
        modifier = modifier
            .padding(bottom = 20.dp)
            .height(341.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = modifier.align(Alignment.Center),
            painter = painterResource(R.drawable.empty_cup),
            contentDescription = null,
        )
        Image(
            painter = painterResource(R.drawable.cup_cover),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = offsetY.value.dp)
                .width(260.dp)
                .height(69.dp)
        )
    }
}

@Composable
fun CupCoffeeWithCover1(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(bottom = 20.dp)
            .height(341.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = modifier.align(Alignment.Center),
            painter = painterResource(R.drawable.empty_cup),
            contentDescription = null,
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 1.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.cup_cover),
                contentDescription = null,
                modifier = Modifier
                    .width(260.dp)
                    .height(69.dp)
            )
        }

    }
}

@Preview(showSystemUi = true, device = "spec:width=360dp,height=800dp")
@Composable
fun CoffeeReadyScreenPrev(modifier: Modifier = Modifier) {
    // CoffeeReadyScreen()
}