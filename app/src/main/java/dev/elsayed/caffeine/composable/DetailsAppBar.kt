package dev.elsayed.caffeine.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.elsayed.caffeine.R
import dev.elsayed.caffeine.ui.theme.Theme
import dev.elsayed.caffeine.ui.theme.Urbanist

@Composable
fun DetailsAppBar(modifier: Modifier = Modifier,onNavClick : ()->Unit = {}) {
    Row(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.statusBars)
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Row(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Theme.colors.surfaceBackground)
                .clickable{onNavClick()},
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.arrow_back),
                contentDescription = null
            )
        }

        Text(
            modifier = Modifier.padding(start = 12.dp).weight(1f),
            text = "Macchiato",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Urbanist
        )
    }
}

@Preview
@Composable
fun DetailsAppBarPrev(modifier: Modifier = Modifier) {
    DetailsAppBar()
}