package com.example.componentszave.ui.components.goal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import com.example.componentszave.ui.theme.dark_theme_green_primary
import com.example.componentszave.ui.theme.dark_theme_grey_light_secondary
import com.example.componentszave.ui.theme.dark_theme_grey_tertiary
import com.example.componentszave.ui.theme.dark_theme_red_primary
import com.example.componentszave.ui.theme.dark_theme_white_tertiary


@Composable
fun TransactionGoalDetail(
    type: String,
    amount: String,
    date: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(dark_theme_grey_tertiary)
            .padding(vertical = 32.dp, horizontal = 24.dp)
    ) {
        Image(
            painter = painterResource(id = if (type == "Deposited") R.drawable.ic_deposit_goal else R.drawable.ic_withdraw_goal),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = type,
            style = ZaveTypography.headlineSmall.copy(
                fontSize = 12.sp,
                color = dark_theme_grey_light_secondary
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = if (type == "Deposited") amount else "- $amount",
            style = ZaveTypography.headlineMedium.copy(
                fontFamily = FontFamily(Font(R.font.outfit_light)),
                color = if (type == "Deposited") dark_theme_green_primary else dark_theme_red_primary
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = date,
            style = ZaveTypography.headlineSmall.copy(
                fontSize = 12.sp
            )
        )
    }
}

@Preview
@Composable
fun TransactionGoalDetailPreview() {
    TransactionGoalDetail("Depositd", "₹23,00.00", "12.07.2023")
}