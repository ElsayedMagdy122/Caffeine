package dev.elsayed.caffeine.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomIconButton(
    modifier: Modifier = Modifier,
    buttonSize: Dp = 48.dp,
    @DrawableRes iconRes: Int,
    contentDescription: String? = null,
    isDropShadow: Boolean = false,
    shadow: DropShadow = DropShadow(
        color = Color(0xFFB94B23).copy(alpha = 0.5f),
        blur = 16.dp,
        offsetY = 6.dp,
    ),
    backgroundColor: Color,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .then(
                if (isDropShadow) {
                    Modifier.dropShadow(
                        shape = shadow.shape,
                        color = shadow.color,
                        offsetX = shadow.offsetX,
                        offsetY = shadow.offsetY,
                        blur = shadow.blur
                    )

                } else Modifier

            )
            .size(buttonSize)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable { onClick },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(iconRes),
            contentDescription = contentDescription, tint = Color.Unspecified
        )
    }
}

data class DropShadow(
    val color: Color,
    val blur: Dp = 0.dp,
    val offsetX: Dp = 0.dp,
    val offsetY: Dp = 0.dp,
    val shape: Shape = CircleShape,
)
