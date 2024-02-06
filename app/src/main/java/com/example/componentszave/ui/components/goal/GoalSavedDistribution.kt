package com.example.componentszave.ui.components.goal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_blue_primary
import com.example.componentszave.ui.theme.dark_theme_yellow_primary


@Composable
fun GoalSavedDistribution(
    savingsCompletedPercentage: String,
    amountDeposited: String,
    rewardEarnedPercentage: String,
    rewardEarnedAmount: String
) {
    Column {
        GoalDistribution(
            circleColor = dark_theme_blue_primary,
            reward = savingsCompletedPercentage,
            rewardTitle = "Savings Completed",
            rewardAmount = amountDeposited,
            rewardType = "Deposited"
        )
        Spacer(modifier = Modifier.height(8.dp))
        GoalDistribution(
            circleColor = dark_theme_yellow_primary,
            reward = rewardEarnedPercentage,
            rewardTitle = "Savings Completed",
            rewardAmount = rewardEarnedAmount,
            rewardType = "Deposited"
        )
    }

}

@Composable
fun GoalDistribution(
    circleColor: Color,
    reward: String,
    rewardTitle: String,
    rewardAmount: String,
    rewardType: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(16.dp)
                .clip(CircleShape)
                .background(circleColor)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = "$reward $rewardTitle", style = ZaveTypography.headlineSmall.copy(
                    fontFamily = FontFamily(Font(R.font.outfit_semi_bold))
                )
            )
            Text(
                text = "$rewardAmount $rewardType", style = ZaveTypography.headlineSmall
            )
        }

    }
}

@Preview
@Composable
fun GoalSavedDistributionPreview() {
    GoalSavedDistribution(
        "10%", "₹ 10,000",
        "10%", "₹ 10,000"
    )
}

