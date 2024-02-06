package com.example.componentszave.ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.white


@Composable
fun SecondaryButton(
    text: String,
    showImage: Boolean = true,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable { onClick }
            .background(Color.Black)
            .height(56.dp)
            .fillMaxWidth()
            .border(BorderStroke(1.dp, Color.White), shape = RectangleShape)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = white,
            fontFamily = FontFamily(Font(R.font.clash_display_medium))
        )
        Spacer(Modifier.padding(start = 10.dp))
        if (showImage) {
            Image(
                painter = painterResource(id = R.drawable.ic_button_icon_white),
                contentDescription = ""
            )
        }
    }
}

@Preview
@Composable
fun PreviewSecondaryButton() {
    SecondaryButton(text = "Login") {
    }
}