package dev.elsayed.caffeine.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.elsayed.caffeine.R
import dev.elsayed.caffeine.state.CaffeineAmount
import dev.elsayed.caffeine.ui.theme.Urbanist

@Composable
fun CoffeePercentageCaffeineOptions(
    selectedCaffeineAmount: CaffeineAmount,
    onChangeCaffeineAmount: (CaffeineAmount) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .width(152.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(Color(0xFFF5F5F5)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CircleCaffeineOption(
                amount = CaffeineAmount.LOW,
                selected = selectedCaffeineAmount == CaffeineAmount.LOW,
                onClick = onChangeCaffeineAmount
            )
            CircleCaffeineOption(
                amount = CaffeineAmount.MEDIUM,
                selected = selectedCaffeineAmount == CaffeineAmount.MEDIUM,
                onClick = onChangeCaffeineAmount
            )
            CircleCaffeineOption(
                amount = CaffeineAmount.HIGH,
                selected = selectedCaffeineAmount == CaffeineAmount.HIGH,
                onClick = onChangeCaffeineAmount
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 2.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val textColor = Color(0x991F1F1F)
            Text(
                text = "Low",
                fontFamily = Urbanist,
                fontSize = 10.sp,
                color = textColor,
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = "Medium",
                fontFamily = Urbanist,
                fontSize = 10.sp,
                color = textColor,
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = "High",
                fontFamily = Urbanist,
                fontSize = 10.sp,
                color = textColor,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}

@Composable
fun CircleCaffeineOption(
    amount: CaffeineAmount,
    selected: Boolean,
    onClick: (CaffeineAmount) -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (selected) Color(0xFF7C351B) else Color.Transparent,
        animationSpec = tween(durationMillis = 600, easing = LinearEasing),
        label = "BackgroundColor"
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
            .clickable { onClick(amount) },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = selected,
            enter = fadeIn(tween(300)),
            exit = fadeOut(tween(300))
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.coffee_beans),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}