package dev.elsayed.caffeine.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.elsayed.caffeine.R
import dev.elsayed.caffeine.composable.CaffeineButton
import dev.elsayed.caffeine.composable.CoffeeCupSlider
import dev.elsayed.caffeine.composable.ProfileAppBar
import dev.elsayed.caffeine.ui.theme.CaffieneTheme
import dev.elsayed.caffeine.ui.theme.Theme
import dev.elsayed.caffeine.ui.theme.Urbanist
import kotlin.math.abs

@Composable
fun CaffeineSliderScreen(modifier: Modifier = Modifier) {
    CaffieneTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.white)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileAppBar()
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Good Morning",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Urbanist,
                        textAlign = TextAlign.Start,
                        letterSpacing = 0.25.sp,
                        color = Theme.colors.titleColor
                    )
                    Text(
                        "Hamsa ☀",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Urbanist,
                        textAlign = TextAlign.Start,
                        letterSpacing = 0.25.sp,
                        color = Theme.colors.questionColorColor2
                    )
                    Text(
                        "What would you like to drink today?",
                        modifier = modifier.padding(top = 4.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Urbanist,
                        textAlign = TextAlign.Start,
                        letterSpacing = 0.25.sp,
                        color = Theme.colors.textColor
                    )
                }
                val coffeeList = listOf(
                    "Black" to painterResource(R.drawable.black),
                    "Latte" to painterResource(R.drawable.lattee),
                    "Macchiato" to painterResource(R.drawable.macchiato),
                    "Espresso" to painterResource(R.drawable.espresso)
                )
                SliderCupsCoffee(coffeeList = coffeeList)
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
}

@Composable
fun SliderCupsCoffee(
    modifier: Modifier = Modifier,
    coffeeList: List<Pair<String, Painter>>,
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { coffeeList.size })

    HorizontalPager(
        state = pagerState,
        modifier = modifier
            .padding(top = 56.dp)
            .requiredWidth(LocalConfiguration.current.screenWidthDp.dp)
            .fillMaxWidth(),
        // pageSpacing = 60.dp,
        contentPadding = PaddingValues(horizontal = 100.dp, vertical = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {  page ->
        val pageOffset =
            (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
        val scale = 1f - (0.35f * abs(pageOffset))
        val coffee = coffeeList[page]

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        transformOrigin = TransformOrigin(0.5f, 0.85f)
                    },
                        contentAlignment = Alignment.BottomCenter
            ) {
                CoffeeCupSlider(
                    coffeeName = coffee.first,
                    coffeeImage = coffee.second,
                    modifier = Modifier .align(Alignment.BottomCenter)
                ) }
        }
}

@Preview(device = "spec:width=360dp,height=800dp", showSystemUi = true)
@Composable
fun CaffeineSliderScreenPrev(modifier: Modifier = Modifier) {
    CaffeineSliderScreen()
}
