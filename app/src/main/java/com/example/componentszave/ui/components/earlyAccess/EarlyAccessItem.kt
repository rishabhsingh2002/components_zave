package com.example.componentszave.ui.components.earlyAccess

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.black
import com.example.componentszave.ui.theme.dark_theme_blue_primary
import com.example.componentszave.ui.theme.dark_theme_yellow_primary
import com.example.componentszave.ui.theme.white


@Composable
fun EarlyAccessItem(perkNumber: Int, imageResource: Int, description: String, code: String) {
    Column(
        modifier = Modifier
            .background(dark_theme_blue_primary)
            .fillMaxWidth()
    ) {
        Text(
            text = "Perk $perkNumber",
            style = ZaveTypography.bodyMedium.copy(white),
            modifier = Modifier.padding(top = 16.dp, start = 20.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 24.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "",
            )
            Text(
                text = description,
                style = ZaveTypography.headlineMedium.copy(white),
                modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp),
            )
        }
        CopyReferralItem(code)
    }
}

@Composable
private fun CopyReferralItem(code: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .background(dark_theme_yellow_primary)
            .padding(vertical = 12.dp, horizontal = 24.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Referral Code - $code",
            style = ZaveTypography.headlineLarge.copy(black),
            modifier = Modifier.weight(1f)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_copy_referral),
            contentDescription = "Copy"
        )
    }
}

@Preview
@Composable
fun EarlyAccessItemPreview() {
    EarlyAccessItem(
        1,
        R.drawable.img_perk_one,
        "Get an extra 10% cash-back reward on your first deposit when your second friend joins.",
        "ZAVE234567"
    )
}