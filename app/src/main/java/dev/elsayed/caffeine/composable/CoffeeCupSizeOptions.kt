package dev.elsayed.caffeine.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.elsayed.caffeine.state.CupSize
import dev.elsayed.caffeine.ui.theme.Urbanist

@Composable
fun CoffeeCupSizeOptions(
    selectedCupSize: CupSize,
    onChangeCupSize: (CupSize) -> Unit
) {

    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(56.dp)
            .width(152.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(Color(0xFFF5F5F5)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        CircleSizeOption(
            textSize = CupSize.S.toString(),
            cupSize = CupSize.S,
            selected = selectedCupSize == CupSize.S,
            onChangeCupSize = onChangeCupSize
        )
        CircleSizeOption(
            textSize = CupSize.M.toString(),
            cupSize = CupSize.M,
            selected = selectedCupSize == CupSize.M,
            onChangeCupSize = onChangeCupSize
        )
        CircleSizeOption(
            textSize = CupSize.L.toString(),
            cupSize = CupSize.L,
            selected = selectedCupSize == CupSize.L,
            onChangeCupSize = onChangeCupSize
        )
    }
}

@Composable
fun CircleSizeOption(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    textSize: String = "S",
    cupSize: CupSize,
    onChangeCupSize: (CupSize) -> Unit
) {

    val backgroundColor by animateColorAsState(
        targetValue = if (selected) Color(0xFF7C351B) else Color.Transparent,
        animationSpec = tween(
            durationMillis = 600,
            easing = LinearEasing
        ),
        label = "BackgroundColor"
    )

    val textColor by animateColorAsState(
        targetValue = if (selected) Color.White else Color(0xFF1F1F1F).copy(alpha = 0.6f),
        animationSpec = tween(
            durationMillis = 600,
            easing = LinearEasing
        ),
        label = "TextColor"
    )
    Column(
        modifier = modifier
            .size(40.dp)
            .then(
                if (selected) Modifier.dropShadow(
                    CircleShape,
                    color = Color(0x80B94B23),
                    offsetY = 6.dp,
                    offsetX = 0.dp,
                    blur = 16.dp,
                ) else Modifier
            )
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable { onChangeCupSize(cupSize) },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = textSize,
            fontFamily = Urbanist,
            fontSize = 20.sp,
            color = textColor,
            fontWeight = FontWeight.Bold,
        )
    }
}