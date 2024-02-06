package com.example.componentszave.ui.components.goal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import com.example.componentszave.ui.theme.dark_theme_yellow_primary
import com.example.componentszave.ui.theme.white

@Composable
fun GoalDetailHeader(
    goalName: String,
    brandName: String,
    brandImage: String,
    categoryName: String,
    categoryImage: String,
    reward: String,
    savingGoalAmount: String
) {
    Box(
        Modifier
            .background(dark_theme_blue_primary)
            .fillMaxWidth()
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
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 22.dp, start = 22.dp, end = 20.dp)
        ) {
            Text(text = goalName, style = ZaveTypography.displayMedium)

            Spacer(modifier = Modifier.height(22.dp))

            Row {
                SetImage(imageUrl = categoryImage, Modifier.size(105.dp))

                Spacer(modifier = Modifier.width(16.dp))

                GoalDetailHeaderGoalDetailHeaderRight(
                    brandName, brandImage, categoryName, reward, savingGoalAmount
                )
            }
        }
    }
}

@Composable
fun GoalDetailHeaderGoalDetailHeaderRight(
    brandName: String,
    brandImage: String,
    categoryName: String,
    reward: String,
    savingGoalAmount: String
) {
    Column {
        Text(text = categoryName, style = ZaveTypography.bodySmall.copy(fontSize = 14.sp))

        Spacer(modifier = Modifier.height(4.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            CircularImage(imageUrl = brandImage, modifier = Modifier.size(11.dp))

            Spacer(modifier = Modifier.width(4.dp))

            Text(text = brandName, style = ZaveTypography.headlineSmall.copy(fontSize = 12.sp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        GoalRewardItem(
            "You’ve earned ",
            reward,
            " in cash-back!",
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
            rewardTextColor = dark_theme_yellow_primary,
            normalTextSize = 12.sp,
            rewardTextSize = 12.sp,
            normalTextColor = white,
            containerColor = Color(0xFFFFFFFF).copy(alpha = 0.10f)
        )

        Spacer(modifier = Modifier.height(4.dp))

        SpannableGoalRewardText(
            "Savings Goal: ",
            savingGoalAmount,
            "",
            white,
            white,
            12.sp,
            12.sp,
            rewardTextFontFamily = R.font.inter_semi_bold,
            normalTextFontFamily = R.font.inter_regular
        )

    }
}

@Preview
@Composable
fun GoalDetailHeaderPreview() {
    GoalDetailHeader(
        "My Iphone", "Apple Inc.", "", "Iphone 14", "", "8%", "₹ 1,00,000.00"
    )
}