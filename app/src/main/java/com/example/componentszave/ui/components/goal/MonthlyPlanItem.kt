package com.example.componentszave.ui.components.goal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.ui.components.brands.GoalRewardItem
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.black
import com.example.componentszave.ui.theme.dark_theme_black_secondary
import com.example.componentszave.ui.theme.dark_theme_black_tertiary
import com.example.componentszave.ui.theme.dark_theme_blue_primary
import com.example.componentszave.ui.theme.dark_theme_grey_dark_secondary
import com.example.componentszave.ui.theme.dark_theme_grey_tertiary
import com.example.componentszave.ui.theme.dark_theme_white_tertiary
import com.example.componentszave.ui.theme.dark_theme_yellow_primary
import com.example.componentszave.ui.theme.white


@Composable
fun MonthlyPlanItem(
    month: String,
    title: String,
    description: String,
    reward: String,
    isSelected: Boolean = true,
    onClick: () -> Unit
) {
    val selected: MutableState<Boolean> = remember { mutableStateOf(isSelected) }

    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
        .clickable {
            selected.value = !selected.value
            onClick()
        }
        .background(if (selected.value) white else dark_theme_grey_tertiary)
        .padding(vertical = 20.dp, horizontal = 16.dp)
        .fillMaxWidth()) {
        Text(
            text = month,
            style = ZaveTypography.headlineLarge.copy(
                fontSize = 20.sp,
                color = if (selected.value) white else black
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 22.dp, horizontal = 12.dp)
                .drawBehind {
                    drawCircle(
                        color = if (selected.value) dark_theme_blue_primary else white,
                        radius = this.size.maxDimension
                    )
                }
        )
        Spacer(modifier = Modifier.padding(start = 16.dp))
        MonthlyPlanRight(title, description, reward, selected)
    }
}

@Composable
fun MonthlyPlanRight(
    title: String,
    description: String,
    reward: String,
    selected: MutableState<Boolean>
) {
    Column(verticalArrangement = Arrangement.Center) {
        Text(
            text = title,
            style = ZaveTypography.bodySmall,
            color = if (selected.value) black else white
        )
        Spacer(modifier = Modifier.padding(top = 6.dp))
        Text(
            text = description,
            style = ZaveTypography.headlineSmall,
            color = if (selected.value) dark_theme_grey_dark_secondary else dark_theme_black_tertiary
        )
        Spacer(modifier = Modifier.padding(top = 12.dp))
        GoalRewardItem(
            preRewardText = "Get ",
            reward,
            postRewardText = " Cashback Reward!",
            normalTextColor = if (selected.value) black else white,
            rewardTextColor = if (selected.value) dark_theme_blue_primary else dark_theme_yellow_primary,
            normalTextSize = 11.sp,
            rewardTextSize = 11.sp,
            containerColor = if (selected.value) dark_theme_black_secondary else dark_theme_white_tertiary,
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp)
        )
    }
}

@Preview
@Composable
fun MonthlyPlanItemPreview() {
    MonthlyPlanItem(
        "2+4", "Fast Buy Plan", "2 months of Savings &\n4 months of No-Cost EMI", "₹ 1,000"
    ) {}
}