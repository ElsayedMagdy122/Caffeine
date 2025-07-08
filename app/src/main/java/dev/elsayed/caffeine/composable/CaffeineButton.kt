package dev.elsayed.caffeine.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    modifier: Modifier = Modifier,
    onNavClick : ()-> Unit = {}
) {
    Button(
        onClick = onNavClick,
        modifier = modifier
            .padding(bottom = 50.dp)
            .height(56.dp)
            .shadow(8.dp, RoundedCornerShape(100.dp)),
        shape = RoundedCornerShape(100.dp),
        contentPadding = PaddingValues(horizontal = 32.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Theme.colors.black)
    ) {
        Text(
            color = Theme.colors.white87,
            text = text,
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
