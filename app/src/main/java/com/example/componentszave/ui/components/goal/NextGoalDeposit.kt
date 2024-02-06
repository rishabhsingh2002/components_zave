package com.example.componentszave.ui.components.goal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_blue_primary
import com.example.componentszave.ui.theme.dark_theme_yellow_primary
import com.example.componentszave.ui.theme.white


@Composable
fun NextGoalDeposit(
    nextSavingAmount: String, nextRewardAwaiting: String
) {
    Column {
        NextGoalItem(dark_theme_blue_primary, "Next Savings Deposit - ", nextSavingAmount)
        Spacer(modifier = Modifier.height(8.dp))
        NextGoalItem(dark_theme_yellow_primary, "Next Rewards Awaiting - ", nextRewardAwaiting)
    }
}

@Composable
fun NextGoalItem(
    color: Color, title: String, amount: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Divider(
            color = color, modifier = Modifier
                .height(1.dp)
                .width(16.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        val string = buildAnnotatedString {
            append(title)
            withStyle(
                style = SpanStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.outfit_semi_bold, FontWeight.W400)),
                    color = white
                )
            ) {
                append(amount)
            }
        }
        Text(
            text = string, style = ZaveTypography.headlineSmall
        )

    }
}

@Preview
@Composable
fun NextGoalItemPreview() {
    NextGoalDeposit("₹ 10,000", "₹ 1,000")
}