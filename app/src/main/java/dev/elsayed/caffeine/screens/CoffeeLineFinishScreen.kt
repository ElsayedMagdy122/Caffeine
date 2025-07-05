package dev.elsayed.caffeine.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.elsayed.caffeine.R
import dev.elsayed.caffeine.composable.CaffeineButton
import dev.elsayed.caffeine.composable.DetailsAppBar
import dev.elsayed.caffeine.ui.theme.Singlet
import dev.elsayed.caffeine.ui.theme.Theme
import dev.elsayed.caffeine.ui.theme.Urbanist
import org.koin.androidx.compose.koinViewModel

@Composable
fun CoffeeLineFinishScreen(modifier: Modifier = Modifier) {
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
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.column),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ff),
                    contentDescription = null,
                    tint = Color.Unspecified, modifier = Modifier.padding(horizontal = 12.dp)
                )
                Text(
                    text = ":",
                    fontFamily = Urbanist,
                    fontSize = 40.sp,
                    color = Color(0xFF1F1F1F).copy(alpha = 0.12f),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ee),
                    contentDescription = null,
                    tint = Color.Unspecified
                )

            }
        }
    }

}

@Preview(showSystemUi = true, device = "spec:width=360dp,height=800dp")
@Composable
fun CoffeeLineFinishScreenPrev(modifier: Modifier = Modifier) {
    CoffeeLineFinishScreen()
}