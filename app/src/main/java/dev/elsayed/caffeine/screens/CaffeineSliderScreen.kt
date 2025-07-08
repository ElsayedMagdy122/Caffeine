package dev.elsayed.caffeine.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.elsayed.caffeine.R
import dev.elsayed.caffeine.composable.CaffeineButton
import dev.elsayed.caffeine.composable.ProfileAppBar
import dev.elsayed.caffeine.navigation.CoffeeMakerScreen
import dev.elsayed.caffeine.ui.theme.CaffieneTheme
import dev.elsayed.caffeine.ui.theme.Theme
import dev.elsayed.caffeine.ui.theme.Urbanist
import kotlin.math.absoluteValue

@Composable
fun CaffeineSliderScreen(modifier: Modifier = Modifier, navController: NavController) {
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
                        stringResource(R.string.good_morning),
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Urbanist,
                        textAlign = TextAlign.Start,
                        letterSpacing = 0.25.sp,
                        color = Theme.colors.titleColor
                    )
                    Text(
                        stringResource(R.string.hamsa),
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Urbanist,
                        textAlign = TextAlign.Start,
                        letterSpacing = 0.25.sp,
                        color = Theme.colors.questionColorColor2
                    )
                    Text(
                        stringResource(R.string.what_would_you_like_to_drink_today),
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
                    stringResource(R.string.black) to painterResource(R.drawable.black),
                    stringResource(R.string.latte) to painterResource(R.drawable.lattee),
                    stringResource(R.string.macchiato) to painterResource(R.drawable.macchiato),
                    stringResource(R.string.espresso) to painterResource(R.drawable.espresso)
                )
                SliderCupsCoffee(drinks = coffeeList)
            }
            CaffeineButton(
                text = "Continue",
                icon = ImageVector.vectorResource(R.drawable.arrow_right_ic),
                onNavClick = {
                    navController.navigate(CoffeeMakerScreen)
                },
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
    drinks: List<Pair<String, Painter>>,
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { drinks.size })
    HorizontalPager(
        modifier = Modifier.padding(top = 56.dp),
        state = pagerState,
        pageSize = PageSize.Fixed(199.dp),
        reverseLayout = true,
        contentPadding = PaddingValues(horizontal = 110.dp)
    ) { page ->
        val currentPageOffset = (
                (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                ).absoluteValue
        val animatedHeight by animateDpAsState(
            targetValue = lerp(244.dp, 150.dp, currentPageOffset.coerceIn(0f, 1f)),
            label = "HeightAnimation"
        )
        val yAxis by animateDpAsState(lerp(0.dp, 94.dp, currentPageOffset.coerceIn(0f, 1f)))
        val logoSize by animateDpAsState(lerp(66.dp, 40.dp, currentPageOffset.coerceIn(0f, 1f)))
        val logoYOffset by animateDpAsState(
            lerp(
                -62.dp,
                -35.dp,
                currentPageOffset.coerceIn(0f, 1f)
            )
        )
        val animatedWidth by animateDpAsState(
            targetValue = lerp(199.dp, 120.dp, currentPageOffset.coerceIn(0f, 1f)),
            label = "WidthAnimation"
        )

    DrinkCard(
        modifier = Modifier.offset(y = yAxis),
        image = drinks[page].second,
        name = drinks[page].first,
        width = animatedWidth.value.dp,
        height = animatedHeight.value.dp,
        logoSize,
        logoYOffset
    )}
}
@Composable
fun DrinkCard(modifier: Modifier = Modifier, image: Painter, name: String,width : Dp, height : Dp,logoSize :Dp,
              logoYOffset: Dp) {
    Column(modifier = modifier.size(199.dp, 298.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier) {
            Image(painter = image,
                contentDescription = null,
                modifier = Modifier
                    .width(width)
                    .height(height),
                contentScale = ContentScale.FillBounds,
            )
            Image(
                painter = painterResource(R.drawable.the_chance_coffe_small),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .size(logoSize)
                    .offset(y = logoYOffset),

                )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = name,
            fontSize = 32.sp,
            letterSpacing = .25.sp,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1F1F1F)

        )
    }
}
@Preview(device = "spec:width=360dp,height=800dp", showSystemUi = true)
@Composable
fun CaffeineSliderScreenPrev(modifier: Modifier = Modifier) {
    CaffeineSliderScreen(navController = rememberNavController())
}
