package com.example.componentszave.ui.components.goal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.components.brands.GoalRewardItem
import com.example.componentszave.ui.components.brands.SpannableGoalRewardText
import com.example.componentszave.ui.components.common.CircularImage
import com.example.componentszave.ui.components.common.SetImage
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_blue_primary
import com.example.componentszave.ui.theme.dark_theme_grey_extra_light_tertiary
import com.example.componentszave.ui.theme.dark_theme_purple_medium_primary
import com.example.componentszave.ui.theme.dark_theme_purple_primary
import com.example.componentszave.ui.theme.dark_theme_purple_secondary
import com.example.componentszave.ui.theme.dark_theme_purple_tertiary
import com.example.componentszave.ui.theme.dark_theme_yellow_primary
import com.example.componentszave.ui.theme.white


@Composable
fun GoalCard(
    goalName: String,
    brandName: String,
    brandImage: String,
    categoryName: String,
    categoryImage: String,
    reward: String,
    cardColor: Color = dark_theme_blue_primary,
    goalAchieved: String,
    months: Int,
    goalProgress: Float,
    savingsAmount: String,
    rewardEarnedAmount: String,
    nextDepositDate: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .clickable { onClick() }
            .border(
                width = 1.dp,
                color = Color(0xFF4E4E4E),
                shape = RoundedCornerShape(size = 8.dp)
            )
            .fillMaxSize()
    ) {
        Box(
            Modifier
                .background(cardColor)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_goals_card_mask),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize()
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(vertical = 48.dp, horizontal = 16.dp)
                    .fillMaxSize()
            ) {
                GoalCardTop(goalName, brandName, brandImage, categoryName, reward)

                Spacer(modifier = Modifier.weight(1f))

                SetImage(imageUrl = categoryImage, Modifier.size(160.dp))

                Spacer(modifier = Modifier.weight(1f))

                GoalCardBottom(
                    goalAchieved = goalAchieved,
                    months = months,
                    goalProgress = goalProgress,
                    savingsAmount = savingsAmount,
                    rewardEarnedAmount = rewardEarnedAmount,
                    nextDepositDate = nextDepositDate
                )
            }
        }
    }
}

@Composable
fun GoalCardTop(
    goalName: String, brandName: String, brandImage: String, categoryName: String, reward: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = goalName, style = ZaveTypography.displayMedium.copy(
                fontFamily = FontFamily(Font(R.font.clash_display_semi_bold)), fontSize = 20.sp
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = categoryName, style = ZaveTypography.headlineMedium.copy(
                fontFamily = FontFamily(Font(R.font.outfit_semi_bold)), color = white
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            CircularImage(imageUrl = brandImage, modifier = Modifier.size(18.dp))

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = brandName, style = ZaveTypography.headlineSmall.copy(fontSize = 12.sp))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.ic_star_start), contentDescription = "")

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                GoalRewardItem(
                    "You’ve earned ",
                    reward,
                    " in cash-back!",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                    rewardTextColor = dark_theme_purple_primary,
                    normalTextSize = 12.sp,
                    rewardTextSize = 12.sp,
                    containerColor = dark_theme_purple_secondary,
                    leftIcon = null,
                    rightIcon = null
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Let’s Go!",
                    style = ZaveTypography.headlineSmall.copy(fontSize = 12.sp)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.ic_star_end), contentDescription = ""
            )
        }

    }
}

@Composable
fun GoalCardBottom(
    goalAchieved: String,
    months: Int,
    goalProgress: Float,
    savingsAmount: String,
    rewardEarnedAmount: String,
    nextDepositDate: String
) {
    Column(
        Modifier
            .fillMaxWidth()
    )
    {
        Row {
            SpannableGoalRewardText(
                "Goal Achieved: ",
                goalAchieved,
                "",
                white,
                dark_theme_grey_extra_light_tertiary,
                14.sp,
                14.sp,
                rewardTextFontFamily = R.font.outfit_regular
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(text = "$months Months Left", style = ZaveTypography.headlineSmall)
        }

        Spacer(modifier = Modifier.height(24.dp))

        CustomLinearProgressIndicator(
            progress = goalProgress
        )

        Spacer(modifier = Modifier.height(16.dp))

        SavingsAndReward(dark_theme_yellow_primary, "Savings:  ", savingsAmount)

        Spacer(modifier = Modifier.height(4.dp))

        SavingsAndReward(dark_theme_purple_medium_primary, "Reward Earned:  ", rewardEarnedAmount)

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Next Deposit Date: $nextDepositDate",
            style = ZaveTypography.headlineSmall,
            color = dark_theme_grey_extra_light_tertiary
        )

    }
}

@Composable
fun SavingsAndReward(
    boxColor: Color,
    title: String,
    amount: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(9.dp)
                .clip(shape = RectangleShape)
                .background(boxColor)
        ) {
        }
        Spacer(modifier = Modifier.width(8.dp))

        SpannableGoalRewardText(
            title,
            amount,
            "",
            white,
            dark_theme_grey_extra_light_tertiary,
            14.sp,
            14.sp,
            rewardTextFontFamily = R.font.outfit_regular
        )

    }
}

@Composable
fun CustomLinearProgressIndicator(
    modifier: Modifier = Modifier,
    progress: Float,
    progressColor: Color = dark_theme_yellow_primary,
    backgroundColor: Color = dark_theme_purple_tertiary,
) {
    Box(
        modifier = modifier
            .background(backgroundColor)
            .height(8.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .background(progressColor)
                .fillMaxHeight()
                .fillMaxWidth(progress)
        )
    }
}

@Preview
@Composable
fun GoalCardPreview() {
    GoalCard(
        "My Iphone",
        "Apple Inc.",
        "",
        "Iphone",
        "",
        "8%",
        dark_theme_blue_primary,
        "25%",
        5,
        0.2f,
        "₹ 50,000",
        "₹ 10,000",
        "05/09/2024"
    ) {}
}