package com.example.componentszave.ui.components.money

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.black
import com.example.componentszave.ui.theme.dark_theme_grey_tertiary
import com.example.componentszave.ui.theme.white

@Composable
fun LinkedBankAccount(
    bankName: String,
    accountNumber: String,
    accountHolderName: String,
    isDeleteButtonVisible: Boolean = true,
    deleteOnClick: () -> Unit,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    val selected: MutableState<Boolean> = remember { mutableStateOf(isSelected) }

    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable {
                if (!isDeleteButtonVisible) {
                    selected.value = !selected.value
                }
                onClick()
            }
            .background(if (selected.value) white else dark_theme_grey_tertiary)
            .padding(top = 24.dp, bottom = 24.dp, start = 28.dp, end = 22.dp)
            .fillMaxWidth()) {
        Image(painter = painterResource(id = R.drawable.ic_bank), contentDescription = "")
        Spacer(modifier = Modifier.width(28.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.weight(1f)
        ) {
            Text(
                text = bankName, style = ZaveTypography.headlineSmall.copy(
                    fontFamily = FontFamily(Font(R.font.outfit_semi_bold))
                ), color = if (selected.value) black else white
            )
            Text(
                text = accountNumber,
                style = ZaveTypography.headlineSmall,
                color = if (selected.value) black else white
            )
            Text(
                text = accountHolderName,
                style = ZaveTypography.headlineSmall,
                color = if (selected.value) black else white
            )
        }
        if (isDeleteButtonVisible) {
            Image(painter = painterResource(id = R.drawable.ic_delete_account),
                contentDescription = "",
                Modifier.clickable { deleteOnClick() })
        }
    }

}

@Preview
@Composable
fun LinkedBankAccountPreview() {
    LinkedBankAccount("ICICI Bank",
        "XXXX   XXXX   XXXX   0000",
        "Arun Prakash",
        isDeleteButtonVisible = true,
        {},
        isSelected = false,
        {})
}

