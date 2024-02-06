package com.example.componentszave.ui.components.money

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.components.button.PrimaryButton
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_black_tertiary
import com.example.componentszave.ui.theme.dark_theme_grey_dark_tertiary

@Composable
fun GoalAndRewardWallet(
    goalAmount: String, rewardAmount: String, withDrawClick: () -> Unit, transferClick: () -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        WalletItem(
            "Goal Wallet",
            goalAmount,
            "Withdraw",
            modifier = Modifier.weight(1f)
        ) { withDrawClick() }
        Spacer(modifier = Modifier.width(22.dp))
        WalletItem(
            "Reward Wallet",
            rewardAmount,
            "Transfer",
            modifier = Modifier.weight(1f)
        ) { transferClick() }
    }

}

@Composable
fun WalletItem(
    title: String,
    amount: String,
    buttonTitle: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(modifier.fillMaxWidth()) {
        Column(
            Modifier
                .background(dark_theme_grey_dark_tertiary)
                .padding(start = 16.dp, top = 16.dp, bottom = 22.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                style = ZaveTypography.headlineSmall.copy(fontSize = 10.sp),
                color = dark_theme_black_tertiary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = amount, style = ZaveTypography.displayMedium.copy(fontSize = 20.sp)
            )
        }
        PrimaryButton(
            text = buttonTitle, fontSize = 14.sp, icon = R.drawable.ic_wallet, onClick = onClick
        )
    }
}

@Preview
@Composable
fun GoalAndRewardWalletPreview() {
    GoalAndRewardWallet("₹ 40,000", "₹ 0", {}, {})
}