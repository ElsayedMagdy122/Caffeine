package dev.elsayed.caffeine.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.elsayed.caffeine.R
import dev.elsayed.caffeine.composable.DetailsAppBar
import dev.elsayed.caffeine.navigation.CoffeeReadyScreen
import dev.elsayed.caffeine.ui.theme.Theme
import dev.elsayed.caffeine.ui.theme.Urbanist
import kotlin.math.sin

@Composable
fun CoffeeLineFinishScreen(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.white)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val bottomOffset = remember { Animatable(-300f) }
            DetailsAppBar(onNavClick = {
                navController.popBackStack()
            }, modifier = Modifier.offset(y = bottomOffset.value.dp)
            )
            Box(
                modifier = modifier
                    .height(341.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier
                        .padding(horizontal = 80.dp, vertical = 48.dp)
                        .height(300.dp)
                        .align(Alignment.TopCenter),
                    painter = painterResource(R.drawable.empty_cup),
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


        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SnakeLoadingAnimation(
                modifier = Modifier
                    .padding(bottom = 37.dp)
                    .fillMaxWidth()
                    .height(32.dp),
                color = Color.Black,
                strokeWidth = 6f,
                waveAmplitude = 30f,
                waveFrequency = 0.022f,
                onAnimationFinished = {
                      navController.navigate(CoffeeReadyScreen)
                }
            )
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Almost Done",
                fontFamily = Urbanist,
                fontSize = 22.sp,
                color = Color(0xDE1F1F1F),
                fontWeight = FontWeight.Bold,

                )
            Text(
                text = "Your coffee will be finish in",
                fontFamily = Urbanist,
                fontSize = 16.sp,
                color = Color(0x991F1F1F),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Row(
                modifier = Modifier.padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.co),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                DotsShape(modifier = Modifier.padding(horizontal = 12.dp))
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ff),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                DotsShape(modifier = Modifier.padding(horizontal = 12.dp))
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ee),
                    contentDescription = null,
                    tint = Color.Unspecified
                )

            }
        }
    }

}

@Composable
fun DotsShape(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.size(height = 12.dp, width = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .size(4.dp)
                .background(Color(0x1F1F1F1F))
                .clip(CircleShape)
        ) { }
        Row(
            modifier = Modifier
                .size(4.dp)
                .background(Color(0x1F1F1F1F))
                .clip(CircleShape)
        ) { }
    }
}

@Composable
fun SnakeLoadingAnimation(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    strokeWidth: Float = 8f,
    waveAmplitude: Float = 50f,
    waveFrequency: Float = 0.08f,
    onAnimationFinished: () -> Unit = {}
) {
    val progress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        progress.animateTo(
            targetValue = 1f, animationSpec = tween(durationMillis = 1600, easing = LinearEasing)
        )
        progress.animateTo(
            targetValue = 0.4f, animationSpec = tween(durationMillis = 1600, easing = LinearEasing)
        )
        onAnimationFinished()
    }
    Canvas(modifier) {
        val path = Path()
        val width = size.width
        val centerY = size.height / 2f
        val endX = (width * progress.value).toInt()

        for (x in 0..endX step 2) {
            val y = centerY + sin(x * waveFrequency) * waveAmplitude
            if (x == 0) path.moveTo(0f, y) else path.lineTo(x.toFloat(), y)
        }
        drawPath(path, color, style = Stroke(strokeWidth))
    }
}

@Preview(showSystemUi = true, device = "spec:width=360dp,height=800dp")
@Composable
fun CoffeeLineFinishScreenPrev(modifier: Modifier = Modifier) {
    //CoffeeLineFinishScreen()
}