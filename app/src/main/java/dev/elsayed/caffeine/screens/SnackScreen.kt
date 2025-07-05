package dev.elsayed.caffeine.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import dev.elsayed.caffeine.R
import dev.elsayed.caffeine.composable.CaffeineButton
import dev.elsayed.caffeine.composable.CustomIconButton
import dev.elsayed.caffeine.ui.theme.CaffieneTheme
import dev.elsayed.caffeine.ui.theme.Singlet
import dev.elsayed.caffeine.ui.theme.Theme
import dev.elsayed.caffeine.ui.theme.Urbanist


@Composable
fun SnackScreen(modifier: Modifier = Modifier) {
    CaffieneTheme {
        Box(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.navigationBars)
                .fillMaxSize()
                .background(Theme.colors.white)
        ) {
            Column(
                modifier = Modifier.align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CaffeineButton(
                    text = "Thank youuu",
                    icon = ImageVector.vectorResource(R.drawable.arrow_right_ic),
                    modifier = Modifier
                        .width(215.dp)

                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(WindowInsets.statusBars),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
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
                MoreEspressoRow()
                Image(
                    painter = painterResource(R.drawable.pancake),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 24.dp).size(height = 310.dp, width = 300.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 12.dp)) {
                    Text(
                        text = "Bon appétit",
                        fontFamily = Urbanist,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp, textAlign = TextAlign.Center
                    )
                    Icon(
                        modifier = Modifier.padding(start = 8.dp),
                        imageVector = ImageVector.vectorResource(R.drawable.magic_wand_01),
                        contentDescription = null, tint = Color.Unspecified
                    )
                }
            }

        }
    }
}

@Composable
fun MoreEspressoRow() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 24.dp)
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.coffee_beans),
            contentDescription = null, tint = Color(0xFF7C351B)
        )
        Text(
            modifier = Modifier.weight(1f),
            text = "More Espresso, Less Depresso",
            fontFamily = Singlet,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp, textAlign = TextAlign.Center, color = Color(0xFF7C351B)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.coffee_beans),
            contentDescription = null, tint = Color(0xFF7C351B)
        )
    }
}

@Preview(showSystemUi = true, device = "spec:width=360dp,height=800dp")
@Composable
fun SnackScreenPrev(modifier: Modifier = Modifier) {
    SnackScreen()
}