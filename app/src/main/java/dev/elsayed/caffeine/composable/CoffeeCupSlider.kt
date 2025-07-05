package dev.elsayed.caffeine.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.elsayed.caffeine.R
import dev.elsayed.caffeine.ui.theme.Urbanist

@Composable
fun CoffeeCupSlider(modifier: Modifier = Modifier, coffeeName: String, coffeeImage: Painter) {
    Box(
        modifier = modifier
            .height(298.dp)
            .width(198.dp)
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.TopCenter),
            painter = coffeeImage,
            contentDescription = null
        )
        Image(
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.Center),
            painter = painterResource(R.drawable.the_chance_coffe_big),
            contentDescription = null
        )
        Text(
            text = coffeeName,
            fontFamily = Urbanist,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(top = 16.dp)
        )
    }
}

@Preview
@Composable
fun CoffeeCupSliderPrev() {
    Row {
        CoffeeCupSlider(coffeeName = "Black", coffeeImage = painterResource(R.drawable.black))
        CoffeeCupSlider(coffeeName = "Latte", coffeeImage = painterResource(R.drawable.lattee))
        CoffeeCupSlider(
            coffeeName = "Macchiato",
            coffeeImage = painterResource(R.drawable.macchiato)
        )
        CoffeeCupSlider(coffeeName = "Espresso", coffeeImage = painterResource(R.drawable.espresso))
    }
}