package com.example.componentszave.ui.components.brands

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.components.common.SetImage
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.black
import com.example.componentszave.ui.theme.dark_theme_blue_primary
import com.example.componentszave.ui.theme.dark_theme_grey_secondary
import com.example.componentszave.ui.theme.dark_theme_grey_tertiary
import com.example.componentszave.ui.theme.dark_theme_yellow_primary
import com.example.componentszave.ui.theme.white


@Composable
fun BrandsDetailItem(
    imageUrl: String,
    categoryName: String,
    reward: String,
    goalSuggestion: String,
    description: String,
    isSelected: Boolean = false,
    onItemClicked: () -> Unit
) {
    val selected: MutableState<Boolean> = remember { mutableStateOf(isSelected) }

    Column(modifier = Modifier
        .clickable {
            selected.value = !selected.value
            onItemClicked()
        }
        .background(if (selected.value) white else dark_theme_grey_tertiary)
        .padding(horizontal = 16.dp, vertical = 24.dp)
        .fillMaxWidth()) {
        BrandDetailTop(selected)
        Spacer(modifier = Modifier.padding(top = 16.dp))
        BrandDetailCenter(categoryName, imageUrl, selected, reward)
        Spacer(modifier = Modifier.padding(top = 24.dp))
        BrandDetailBottom(goalSuggestion, description, selected)
    }
}

@Composable
private fun BrandDetailTop(selected: MutableState<Boolean>) {
    Row(
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
        RadioButton(
            modifier = Modifier.size(16.dp),
            selected = selected.value,
            onClick = {},
            colors = RadioButtonDefaults.colors(
                selectedColor = dark_theme_blue_primary, unselectedColor = white
            )
        )
        Spacer(modifier = Modifier.padding(start = 8.dp))
        Text(
            text = if (selected.value) "Selected" else "Not Selected",
            style = ZaveTypography.headlineSmall.copy(
                fontSize = 12.sp, color = if (selected.value) dark_theme_blue_primary else white
            )
        )
    }
}

@Composable
fun BrandDetailCenter(
    categoryName: String, imageUrl: String, selected: MutableState<Boolean>, reward: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = categoryName, style = ZaveTypography.headlineLarge.copy(
                    fontFamily = FontFamily(
                        Font(R.font.outfit_medium)
                    ), color = if (selected.value) black else white
                ), textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(top = 12.dp))
            GoalRewardItem(
                preRewardText = "Get ",
                reward,
                postRewardText = "",
                modifier = Modifier.padding(horizontal = 0.dp, vertical = 0.dp),
                normalTextColor = if (selected.value) black else white,
                rewardTextColor = if (selected.value) dark_theme_blue_primary else dark_theme_yellow_primary,
                normalTextSize = 12.sp,
                rewardTextSize = 15.sp,
                containerColor = Color.Transparent
            )
            Spacer(modifier = Modifier.padding(top = 2.dp))
            Text(
                text = "Cash-back",
                style = ZaveTypography.labelSmall,
                color = if (selected.value) black else white
            )
        }
        Spacer(modifier = Modifier.padding(start = 16.dp))
        SetImage(
            imageUrl = imageUrl, modifier = Modifier
                .width(80.dp)
                .height(100.dp)
        )
    }
}

@Composable
fun BrandDetailBottom(
    goalSuggestion: String,
    description: String,
    selected: MutableState<Boolean>,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Goal Suggestion",
            style = ZaveTypography.titleSmall,
            color = if (selected.value) black else dark_theme_grey_secondary
        )
        Text(
            text = goalSuggestion,
            style = ZaveTypography.bodyMedium,
            color = if (selected.value) dark_theme_blue_primary else white
        )
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Text(
            text = description,
            textAlign = TextAlign.Center,
            style = ZaveTypography.labelSmall.copy(
                fontFamily = FontFamily(Font(R.font.outfit_extra_light)),
                fontSize = 12.sp,
                color = dark_theme_grey_secondary
            )
        )
    }

}

@Preview
@Composable
fun BrandsDetailItemPreview() {
    BrandsDetailItem(
        "",
        "Iphone",
        "7%",
        "₹ 70,000.00  -  ₹ 1,00,000.00",
        "Powerful. Beautiful. Durable. Apple iPhone 14, 14 Pro, 13, 12 and SE series are power packed with long-lasting battery, the new A15 & A16 Bionic chip, super fast 5G Cellular, and a beautiful user experience.",
        true
    ) {

    }

}