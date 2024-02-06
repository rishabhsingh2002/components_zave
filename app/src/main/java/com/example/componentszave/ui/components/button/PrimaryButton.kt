package com.example.componentszave.ui.components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.dark_theme_yellow_primary


@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 16.sp,
    fontFamily: Int = R.font.clash_display_medium,
    showImage: Boolean = true,
    icon: Int = R.drawable.ic_button_icon,
    onClick: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .clickable { onClick }
            .background(dark_theme_yellow_primary)
            .height(56.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            color = Color.Black,
            fontFamily = FontFamily(Font(fontFamily))
        )
        if (showImage) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "",
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}


@Preview
@Composable
fun PreviewPrimaryButton() {
    PrimaryButton(
        text = "Join the Clan"
    ) {

    }
}