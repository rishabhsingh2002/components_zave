package com.example.componentszave.ui.components.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_grey_light_secondary
import com.example.componentszave.ui.theme.dark_theme_grey_tertiary


@Composable
fun ZaveFlexibility() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ZaveFlexibilityItem(
            R.drawable.img_flexibility_one,
            "No Price Lock!",
            "The price of product may reduce when you're ready to buy, don't commit to today's price."
        )
        ZaveFlexibilityItem(
            R.drawable.img_flexibility_two,
            "Withdraw Anytime!",
            "Withdraw or cancel the goal anytime, you own your Savings."
        )
        ZaveFlexibilityItem(
            R.drawable.img_flexibility_three,
            "Switch Brands!",
            "Change your brand anytime in between savings journey."
        )

    }

}

@Composable
fun ZaveFlexibilityItem(
    imageResource: Int, title: String, description: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(dark_theme_grey_tertiary)
            .padding(end = 24.dp)
            .fillMaxWidth()
    ) {
        Image(painter = painterResource(id = imageResource), contentDescription = "")
        Spacer(modifier = Modifier.padding(start = 16.dp))

        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = title,
                style = ZaveTypography.headlineSmall.copy(fontFamily = FontFamily(Font(R.font.outfit_semi_bold)))
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(
                text = description,
                style = ZaveTypography.headlineSmall.copy(fontSize = 12.sp),
                color = dark_theme_grey_light_secondary
            )
        }

    }

}

@Preview
@Composable
fun ZaveFlexibilityPreview() {
    ZaveFlexibility()
}