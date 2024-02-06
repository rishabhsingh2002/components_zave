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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.components.common.CircularImage
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.black
import com.example.componentszave.ui.theme.dark_theme_black_secondary
import com.example.componentszave.ui.theme.dark_theme_blue_primary
import com.example.componentszave.ui.theme.dark_theme_grey_tertiary
import com.example.componentszave.ui.theme.dark_theme_white_tertiary
import com.example.componentszave.ui.theme.dark_theme_yellow_primary
import com.example.componentszave.ui.theme.white


@Composable
fun SelectBrand(
    imageUrl: String, brandName: String, onClick: () -> Unit
) {
    Row(
        Modifier
            .clickable { onClick }
            .background(white)
            .padding(horizontal = 18.dp, vertical = 11.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        SelectBrandStart(imageUrl, brandName, 12.sp)
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_bidirection),
            contentDescription = "Select Brand"
        )
    }

}


@Composable
fun SelectBrandItem(
    imageUrl: String,
    brandName: String,
    reward: String,
    isSelected: Boolean = true,
    onClick: () -> Unit
) {
    val selected: MutableState<Boolean> = remember { mutableStateOf(isSelected) }

    Row(
        Modifier
            .clickable {
                selected.value = !selected.value
                onClick()
            }
            .background(if (selected.value) white else dark_theme_grey_tertiary)
            .padding(horizontal = 18.dp, vertical = 11.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        SelectBrandStart(imageUrl, brandName, fontColor = if (selected.value) black else white)
        Spacer(modifier = Modifier.weight(1f))
        GoalRewardItem(
            preRewardText = "Get ",
            reward,
            postRewardText = " back!",
            normalTextColor = if (selected.value) black else white,
            rewardTextColor = if (selected.value) dark_theme_blue_primary else dark_theme_yellow_primary,
            normalTextSize = 10.sp,
            rewardTextSize = 10.sp,
            containerColor = if (selected.value) dark_theme_black_secondary else dark_theme_white_tertiary
        )
    }
}

@Composable
fun SelectBrandStart(
    imageUrl: String, brandName: String, fontSize: TextUnit = 14.sp, fontColor: Color = black
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        CircularImage(
            imageUrl = imageUrl, Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.padding(start = 8.dp))
        Text(
            text = brandName,
            color = fontColor,
            style = ZaveTypography.bodyMedium.copy(fontSize = fontSize)
        )
    }
}

@Preview
@Composable
fun SelectBrandPreview() {
    Column {
        SelectBrand("", "Apple Inc.") {}
        Spacer(modifier = Modifier.padding(8.dp))
        SelectBrandItem("", "Apple Inc.", " 7-8%", isSelected = true) {}

    }
}