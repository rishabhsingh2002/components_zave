package com.example.componentszave.ui.components.bank

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.example.componentszave.ui.theme.dark_theme_grey_light_secondary


@Composable
fun BankTitleWithLogo() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Safe and secure with",
            style = ZaveTypography.headlineSmall.copy(dark_theme_grey_light_secondary)
        )
        Spacer(Modifier.padding(start = 6.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_rbl_bank_logo),
            contentDescription = "RBL Bank"
        )
    }
}

@Preview
@Composable
fun BankTitleWithLogoPreview() {
    BankTitleWithLogo()
}