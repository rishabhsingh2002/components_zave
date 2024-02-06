package com.example.componentszave.ui.components.brands

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.components.common.CircularImage
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_grey_tertiary
import com.example.componentszave.ui.theme.dark_theme_yellow_primary


@Composable
fun BrandsItem(imageUrl: String, brand: String, reward: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(dark_theme_grey_tertiary)
            .padding(vertical = 28.dp)
            .fillMaxWidth()
    ) {
        CircularImage(imageUrl = imageUrl, Modifier.size(50.dp))
        Spacer(Modifier.padding(top = 16.dp))
        Text(text = brand, style = ZaveTypography.headlineSmall)
        Spacer(Modifier.padding(top = 16.dp))
        SpannableBrandItemText(reward)
        Text(text = "With Zave", style = ZaveTypography.labelSmall)
        Spacer(Modifier.padding(top = 16.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_next_brand),
            contentDescription = "Brand Detail"
        )
    }
}

@Composable
fun SpannableBrandItemText(reward: String) {
    val string = buildAnnotatedString {
        append("Get ")
        withStyle(
            style = SpanStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.outfit_semi_bold, FontWeight.W400)),
                color = dark_theme_yellow_primary
            )
        ) {
            append(reward)
        }
        append(" rewards!")
    }
    Text(text = string, style = ZaveTypography.headlineSmall.copy(fontSize = 12.sp))
}

@Preview
@Composable
fun BrandsItemPreview() {
    BrandsItem("", "Apple Inc.", "7%-8%")
}