package dev.elsayed.caffeine.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EmptyScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .background(Color.Yellow)
        ) {

            Box(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .height(200.dp)
                    .width(200.dp)
                    .background(Color.Gray)
            ) {
                Text(text = "Elsayed Magdy", modifier = Modifier.align(Alignment.BottomCenter))
            }

        }

    }
}

@Preview(device = "spec:width=360dp,height=800dp")
@Composable
fun EmptyScreenPrev(modifier: Modifier = Modifier) {
    EmptyScreen()
}