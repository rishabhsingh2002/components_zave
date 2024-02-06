package com.example.componentszave.ui.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.dark_theme_grey_light_primary
import com.example.componentszave.ui.theme.white


@Composable
fun CancelButton(
    text: String,
    modifier: Modifier = Modifier,
    onCLick: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .clickable { onCLick() }
            .background(dark_theme_grey_light_primary)
            .padding(horizontal = 32.dp, vertical = 12.dp)) {
        Text(
            text = text,
            fontSize = 14.sp,
            color = white,
            fontFamily = FontFamily(Font(R.font.clash_display_medium)),
        )
    }
}

@Preview
@Composable
fun PreviewCancelButton() {
    CancelButton(text = "Yes") {

    }
}