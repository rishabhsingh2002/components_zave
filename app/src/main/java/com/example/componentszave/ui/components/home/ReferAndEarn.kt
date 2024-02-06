package com.example.componentszave.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.components.button.PrimaryButton
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_grey_light_secondary

@Composable
fun ReferAndEarn(
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    )
    {
        Image(painter = painterResource(id = R.drawable.img_referral_home), contentDescription = "")

        Spacer(modifier = Modifier.width(20.dp))

        Column {
            Text(text = "Refer & Earn!", style = ZaveTypography.displaySmall.copy(fontSize = 14.sp))

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "With great Referral comes great Benefits.",
                style = ZaveTypography.headlineSmall.copy(color = dark_theme_grey_light_secondary)
            )

            Spacer(modifier = Modifier.height(24.dp))

            PrimaryButton(
                text = "Earn Mega!",
                fontSize = 14.sp,
                fontFamily = R.font.outfit_regular,
                modifier = Modifier.height(42.dp)
            ) {
                onClick()
            }
        }
    }
}

@Preview
@Composable
fun ReferAndEarnPreview() {
    ReferAndEarn() {}
}