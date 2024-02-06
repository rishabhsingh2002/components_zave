package com.example.componentszave.ui.components.brands

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.black
import com.example.componentszave.ui.theme.dark_theme_blue_primary
import com.example.componentszave.ui.theme.dark_theme_grey_medium_secondary


@Composable
fun GoalRewardItem(
    preRewardText: String,
    reward: String,
    postRewardText: String,
    modifier: Modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp),
    normalTextColor: Color = black,
    rewardTextColor: Color = dark_theme_blue_primary,
    normalTextSize: TextUnit = 14.sp,
    rewardTextSize: TextUnit = 14.sp,
    normalTextFontFamily: Int = R.font.outfit_regular,
    rewardTextFontFamily: Int = R.font.outfit_semi_bold,
    containerColor: Color = dark_theme_grey_medium_secondary,
    leftIcon: Int? = R.drawable.ic_reward_start,
    rightIcon: Int? = R.drawable.ic_reward_end
) {
    Card(
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
        ),
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            if (leftIcon != null) {
                Image(
                    painter = painterResource(id = leftIcon), contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.padding(start = 4.dp))
            SpannableGoalRewardText(
                preRewardText,
                reward,
                postRewardText,
                normalTextColor,
                rewardTextColor,
                normalTextSize,
                rewardTextSize,
                normalTextFontFamily = normalTextFontFamily,
                rewardTextFontFamily = rewardTextFontFamily
            )
            Spacer(modifier = Modifier.padding(end = 4.dp))
            if (rightIcon != null) {
                Image(
                    painter = painterResource(id = rightIcon), contentDescription = ""
                )
            }
        }
    }
}

@Composable
fun SpannableGoalRewardText(
    preRewardText: String,
    reward: String,
    postRewardText: String,
    normalTextColor: Color,
    rewardTextColor: Color,
    normalTextSize: TextUnit,
    rewardTextSize: TextUnit,
    normalTextFontFamily: Int = R.font.outfit_regular,
    rewardTextFontFamily: Int = R.font.outfit_semi_bold,
    modifier: Modifier = Modifier
) {
    val string = buildAnnotatedString {
        append(preRewardText)
        withStyle(
            style = SpanStyle(
                fontSize = rewardTextSize,
                fontFamily = FontFamily(Font(rewardTextFontFamily, FontWeight.W400)),
                color = rewardTextColor
            )
        ) {
            append(reward)
        }
        append(postRewardText)
    }
    Text(
        text = string, style = ZaveTypography.headlineSmall.copy(
            fontFamily = FontFamily(Font(normalTextFontFamily)),
            color = normalTextColor,
            fontSize = normalTextSize
        )
    )
}

@Preview
@Composable
fun GoalRewardItemPreview() {
    GoalRewardItem("Get ", "10%", " Cashback Reward!")

}