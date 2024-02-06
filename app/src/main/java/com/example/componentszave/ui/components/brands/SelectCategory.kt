package com.example.componentszave.ui.components.brands

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.components.common.SetImage
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.black
import com.example.componentszave.ui.theme.dark_theme_black_secondary
import com.example.componentszave.ui.theme.dark_theme_black_tertiary
import com.example.componentszave.ui.theme.dark_theme_blue_primary
import com.example.componentszave.ui.theme.dark_theme_grey_tertiary
import com.example.componentszave.ui.theme.dark_theme_white_tertiary
import com.example.componentszave.ui.theme.dark_theme_yellow_primary
import com.example.componentszave.ui.theme.white


@Composable
fun SelectCategory(
    imageUrl: String,
    brandName: String,
    reward: String,
    goalSuggestion: String,
    isSelected: Boolean = true,
    isRightIconVisible: Boolean = true,
    onClick: () -> Unit
) {
    val selected: MutableState<Boolean> = remember { mutableStateOf(isSelected) }

    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
        .clickable {
            selected.value = !selected.value
            onClick()
        }
            .background(if (selected.value) white else dark_theme_grey_tertiary)
        .padding(16.dp)
        .fillMaxWidth()) {
        SetImage(imageUrl = imageUrl, Modifier.size(76.dp))
        Spacer(modifier = Modifier.padding(start = 16.dp))
        Column {
            Text(
                text = brandName, style = ZaveTypography.bodySmall.copy(
                    fontSize = 14.sp, color = if (selected.value) black else white
                )
            )
            Spacer(modifier = Modifier.padding(top = 6.dp))
            GoalRewardItem(
                preRewardText = "Get ",
                reward,
                postRewardText = " back!",
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp),
                normalTextColor = if (selected.value) black else white,
                rewardTextColor = if (selected.value) dark_theme_blue_primary else dark_theme_yellow_primary,
                normalTextSize = 10.sp,
                rewardTextSize = 10.sp,
                containerColor = if (selected.value) dark_theme_black_secondary else dark_theme_white_tertiary
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(
                text = "Goal Suggestion",
                style = ZaveTypography.titleSmall.copy(if (selected.value) black else white)
            )
            Spacer(modifier = Modifier.padding(top = 4.dp))
            Text(
                text = goalSuggestion, style = ZaveTypography.bodyMedium.copy(
                    fontSize = 12.sp, color = dark_theme_black_tertiary
                )
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        if (isRightIconVisible) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_bidirection),
                contentDescription = "Select Brand"
            )
        }
    }
}

@Preview
@Composable
fun SelectCategoryPreview() {
    SelectCategory("", "Iphone", "7%", "₹ 70,000.00  -  ₹ 1,00,000.00") {}
}