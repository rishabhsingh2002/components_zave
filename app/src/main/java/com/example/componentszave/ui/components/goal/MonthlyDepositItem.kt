package com.example.componentszave.ui.components.goal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_grey_light_secondary
import com.example.componentszave.ui.theme.white


@Composable
fun MonthlyDepositItem(
    amount: String, date: String, isDeposited: Boolean
) {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = if (isDeposited) R.drawable.img_deposited else R.drawable.img_not_deposited),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))
        Text(
            text = amount, style = ZaveTypography.labelSmall.copy(
                fontFamily = FontFamily(
                    Font(
                        R.font.outfit_semi_bold, FontWeight.W400
                    )
                )
            ), color = if (isDeposited) white else dark_theme_grey_light_secondary
        )
        Spacer(modifier = Modifier.padding(top = 4.dp))
        Text(
            text = if (isDeposited) "Saved on" else "Due on",
            style = ZaveTypography.headlineSmall.copy(
                fontSize = 10.sp, color = dark_theme_grey_light_secondary
            )
        )
        Text(
            text = date, style = ZaveTypography.headlineSmall.copy(
                fontSize = 10.sp, color = dark_theme_grey_light_secondary
            )
        )
    }
}

@Preview
@Composable
fun MonthlyDepositItemPreview() {
    MonthlyDepositItem("INR 10,000", "01•01•23", true)
}
