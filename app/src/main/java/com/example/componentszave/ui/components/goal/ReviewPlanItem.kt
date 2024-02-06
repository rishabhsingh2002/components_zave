package com.example.componentszave.ui.components.goal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.componentszave.ui.theme.dark_theme_grey_light_secondary
import com.example.componentszave.ui.theme.dark_theme_grey_medium_tertiary
import com.example.componentszave.ui.theme.dark_theme_grey_tertiary
import com.example.componentszave.ui.theme.dark_theme_yellow_primary
import com.example.componentszave.ui.theme.white


@Composable
fun ReviewPlanItem(
    savingDepositSuggestion: String,
    savingDepositAmount: String,
    noCostEmiSuggestion: String,
    noCostEmiAmount: String,
    rewardOnSavingSuggestion: String,
    rewardOnSavingAmount: String,
    youOnlyPayAmount: String,
    purchaseAmount: String
) {
    Column(
        Modifier
            .background(dark_theme_grey_tertiary)
            .fillMaxWidth()
    ) {
        Column(
            Modifier
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Review Your Plan",
                style = ZaveTypography.headlineSmall.copy(dark_theme_grey_light_secondary)
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            ReviewPlanDetailItem("Savings Deposit", savingDepositAmount, savingDepositSuggestion)
            Spacer(modifier = Modifier.padding(top = 16.dp))
            ReviewPlanDetailItem("No Cost-EMI", noCostEmiAmount, noCostEmiSuggestion)
            Spacer(modifier = Modifier.padding(top = 16.dp))
            ReviewPlanDetailItem(
                "Reward on Savings",
                "-$rewardOnSavingAmount",
                rewardOnSavingSuggestion,
                dark_theme_yellow_primary
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Divider(thickness = 1.dp, color = dark_theme_grey_medium_tertiary)
            Spacer(modifier = Modifier.padding(top = 20.dp))
            ReviewPlanDetailItem("You Only Pay", youOnlyPayAmount, null)
        }
        ReviewPlanBottom(rewardOnSavingAmount, purchaseAmount)
    }
}

@Composable
fun ReviewPlanDetailItem(
    title: String, amount: String, suggestion: String?, color: Color = white
) {
    Column {
        Row {
            Text(
                text = title,
                style = ZaveTypography.headlineSmall.copy(color),
                modifier = Modifier.weight(1f)
            )
            Text(
                text = amount, style = ZaveTypography.headlineSmall.copy(
                    fontFamily = FontFamily(
                        Font(R.font.outfit_semi_bold)
                    ), color = color
                )
            )
        }
        suggestion?.let {
            Text(
                text = it, style = ZaveTypography.headlineSmall.copy(color)
            )
        }
    }
}

@Composable
fun ReviewPlanBottom(saving: String, purchaseAmount: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(dark_theme_blue_primary)
            .padding(vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "You get cash-back reward of",
            style = ZaveTypography.headlineSmall.copy(fontSize = 12.sp)
        )
        Spacer(modifier = Modifier.padding(top = 12.dp))
        Text(
            text = saving, style = ZaveTypography.displayMedium.copy(
                fontFamily = FontFamily(Font(R.font.clash_display_semi_bold)),
                color = dark_theme_yellow_primary
            )
        )
        Spacer(modifier = Modifier.padding(top = 12.dp))
        SpannableReviewPlanText(purchaseAmount)
    }
}


@Composable
fun SpannableReviewPlanText(amount: String) {
    val string = buildAnnotatedString {
        append("On purchase of ")
        withStyle(
            style = SpanStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.outfit_semi_bold, FontWeight.W400))
            )
        ) {
            append(amount)
        }
        append(" from brand Partner.")
    }
    Text(text = string, style = ZaveTypography.headlineSmall.copy(fontSize = 12.sp))
}

@Preview
@Composable
fun ReviewPlanItemPreview() {
    ReviewPlanItem(
        "(₹ 10,000/2 Months)",
        "₹ 20,000",
        "(₹ 10,000/4 Months)",
        "₹ 40,000",
        "(10% of ₹ 20,000)",
        "₹ 2,000",
        "₹ 58,000",
        "₹60,000"
    )
}