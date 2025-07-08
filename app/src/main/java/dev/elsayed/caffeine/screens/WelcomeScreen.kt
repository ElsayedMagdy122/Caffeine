package dev.elsayed.caffeine.screens

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
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
import dev.elsayed.caffeine.navigation.CaffeineSliderScreen
import dev.elsayed.caffeine.R
import dev.elsayed.caffeine.composable.CaffeineButton
import dev.elsayed.caffeine.composable.ProfileAppBar
import dev.elsayed.caffeine.ui.theme.CaffieneTheme
import dev.elsayed.caffeine.ui.theme.Singlet
import dev.elsayed.caffeine.ui.theme.Theme

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier, navController: NavController) {
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
                MagicTextWithStars()
                CoffeeGhost()
                Spacer(modifier = Modifier.weight(1f))
            }
            CaffeineButton(
                text = "bring my coffee",
                icon = ImageVector.vectorResource(R.drawable.coffee_cup),
                onNavClick ={ navController.navigate(
                    CaffeineSliderScreen
                )} ,
                modifier = Modifier
                    .width(215.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
private fun CoffeeGhost() {
    val infiniteTransition = rememberInfiniteTransition(label = "ghost_float")
    val ghostOffsetY by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = -15f, animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "ghost_float_y"
    )
    val shadowAlpha by infiniteTransition.animateFloat(
        initialValue = 1f, targetValue = 0.5f, animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "shadow_alpha"
    )
    val shadowOffsetY by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 15f, animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "shadow_offset_y"
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .offset(y = ghostOffsetY.dp)
                .padding(top = 33.dp, start = 58.dp, end = 58.dp),
            painter = painterResource(R.drawable.coffee_ghost),
            contentDescription = null
        )
        Icon(
            modifier = Modifier
                .offset(y = shadowOffsetY.dp)
                .blur(12.dp)
                .padding(top = 2.5.dp),
            imageVector = ImageVector.vectorResource(R.drawable.ghost_shadow_ic),
            contentDescription = "Ghost Shadow",
            tint = Color.Unspecified.copy(alpha = shadowAlpha)
        )
    }
}

@Composable
private fun MagicTextWithStars(
    modifier: Modifier = Modifier,
) {
    val star = ImageVector.vectorResource(id = R.drawable.star)

    Box(modifier = Modifier.padding(top = 24.dp)) {
        Box(
            modifier = modifier.height(height = 200.dp)
        ) {
            TwinklingStar(
                imageVector = star,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 65.dp, start = 10.dp)
            )

            TwinklingStar(
                imageVector = star,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 6.dp, end = 1.dp)
            )

            Text(
                "Hocus \nPocus\nI Need Coffee\nto Focus",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = Singlet,
                lineHeight = 50.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
                color = Theme.colors.textColor
            )
        }

        TwinklingStar(
            imageVector = star,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = (16).dp, y = (0).dp)
        )
    }
}

@Composable
fun TwinklingStar(
    modifier: Modifier = Modifier, imageVector: ImageVector
) {
    val infiniteTransition = rememberInfiniteTransition(label = "star_animation")

    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.2f, targetValue = 1f, animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "alpha_anim"
    )

    Icon(
        imageVector = imageVector,
        contentDescription = "Twinkling Star",
        modifier = modifier,
        tint = Color.Unspecified.copy(alpha = alpha)
    )
}

@Preview(device = "spec:width=360dp,height=800dp", showSystemUi = true)
@Composable
fun WelcomeScreenPrev(modifier: Modifier = Modifier) {
    // WelcomeScreen()
}
