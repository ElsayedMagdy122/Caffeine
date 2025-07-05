package dev.elsayed.caffeine.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.elsayed.caffeine.R
import dev.elsayed.caffeine.composable.CaffeineButton
import dev.elsayed.caffeine.composable.CustomIconButton
import dev.elsayed.caffeine.ui.theme.CaffieneTheme
import dev.elsayed.caffeine.ui.theme.Theme
import dev.elsayed.caffeine.ui.theme.Urbanist

@Composable
fun CoffeeReadyScreen(modifier: Modifier = Modifier) {
    CaffieneTheme {
        Box(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.navigationBars)
                .fillMaxSize()
                .background(Theme.colors.white)
        ) {
            Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                TakeAwaySwitch(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
               CaffeineButton(
                    text = "Take snack",
                    icon = ImageVector.vectorResource(R.drawable.arrow_right_ic),
                    modifier = Modifier
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
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CustomIconButton(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp),
                        buttonSize = 48.dp,
                        iconRes = R.drawable.cancel_01,
                        contentDescription = null,
                        isDropShadow = false,
                        backgroundColor = Theme.colors.surfaceBackground,
                        onClick = { }
                    )
                }

                CupCoffeeReady(modifier = Modifier.padding(top = 16.dp))
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
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .height(40.dp)
                .width(76.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(Color(0xFFFFEEE7)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                text = "OFF",
                fontFamily = Urbanist,
                fontSize = 10.sp,
                color = Theme.colors.textColor,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )
            Icon(
                painter = painterResource(R.drawable.coffee_circle),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = "Take Away",
            fontFamily = Urbanist,
            fontSize = 22.sp,
            color = Theme.colors.textColor,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
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
    CoffeeReadyScreen()
}