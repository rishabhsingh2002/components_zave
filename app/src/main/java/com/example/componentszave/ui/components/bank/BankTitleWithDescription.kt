package com.example.componentszave.ui.components.bank

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_yellow_secondary


@Composable
fun BankTitleWithDescription() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
    ) {
        BankTitleWithLogo()
        Spacer(modifier = Modifier.padding(top = 12.dp))
        Text(
            text = "Your money is secured by an RBI-regulated RBL bank escrow account through Castler.",
            style = ZaveTypography.headlineSmall.copy(dark_theme_yellow_secondary),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun BankWithDescriptionPreview() {
    BankTitleWithDescription()
}
