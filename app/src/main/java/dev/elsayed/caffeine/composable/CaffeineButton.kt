package dev.elsayed.caffeine.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.elsayed.caffeine.ui.theme.Theme
import dev.elsayed.caffeine.ui.theme.Urbanist

@Composable
fun CaffeineButton(
    text:String ,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(bottom = 50.dp)
            .height(56.dp)
            .shadow(8.dp, RoundedCornerShape(100.dp))
            .clip(RoundedCornerShape(100.dp))
            .background(Theme.colors.black)
            .padding(horizontal = 32.dp, vertical = 0.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            color = Theme.colors.white87,
            text = text,
            modifier = Modifier,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Urbanist
        )
        Icon(
            modifier = Modifier.padding(start = 8.dp),
            imageVector = icon,
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}
