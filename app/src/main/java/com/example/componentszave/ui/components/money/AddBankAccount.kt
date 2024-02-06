package com.example.componentszave.ui.components.money

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.white


@Composable
fun AddBankAccount(
    onClick: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onClick() }
            .border(border = BorderStroke(width = 1.dp, white))
            .padding(vertical = 16.dp, horizontal = 28.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_add_bank),
            contentDescription = "Add Bank Account"
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "Add a Bank Account", style = ZaveTypography.headlineSmall)
    }
}

@Preview
@Composable
fun AddBankAccountPreview() {
    AddBankAccount() {}
}