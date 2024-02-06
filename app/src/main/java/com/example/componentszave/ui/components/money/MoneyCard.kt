package com.example.componentszave.ui.components.money

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_grey_dark_tertiary


@Composable
fun MoneyCard(
    totalBalance: String, accountNumber: String, userName: String
) {
    Column(
        Modifier
            .background(dark_theme_grey_dark_tertiary)
            .padding(vertical = 24.dp, horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Total Balance", style = ZaveTypography.headlineSmall.copy(fontSize = 10.sp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = totalBalance, style = ZaveTypography.displayLarge.copy(fontSize = 28.sp))
        Spacer(modifier = Modifier.height(28.dp))
        Text(text = accountNumber, style = ZaveTypography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "$userName's RBL Bank Virtual Escrow Account",
            style = ZaveTypography.headlineSmall
        )
        Spacer(modifier = Modifier.height(28.dp))
        Image(painter = painterResource(id = R.drawable.ic_rbl_bw), contentDescription = "")
    }


}

@Preview
@Composable
fun MoneyCardPreview() {
    MoneyCard("₹  40,000", "XXXX - XXXX - XXXX - XXXX", "Akash")
}