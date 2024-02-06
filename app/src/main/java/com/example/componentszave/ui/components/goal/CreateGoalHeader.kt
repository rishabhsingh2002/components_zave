package com.example.componentszave.ui.components.goal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.ui.components.brands.GoalRewardItem
import com.example.componentszave.ui.components.common.CircularImage
import com.example.componentszave.ui.components.common.SetImage
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.black
import com.example.componentszave.ui.theme.dark_theme_blue_primary
import com.example.componentszave.ui.theme.white

@Composable
fun CreateGoalHeader(
    brandImage: String,
    brandName: String,
    categoryImage: String,
    categoryName: String,
    reward: String
) {
    Column {
        Row(
            modifier = Modifier
                .background(dark_theme_blue_primary)
                .padding(start = 16.dp, top = 12.dp, bottom = 12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularImage(
                imageUrl = brandImage, Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.padding(start = 8.dp))
            Text(text = brandName, style = ZaveTypography.headlineSmall.copy(fontSize = 12.sp))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .background(white)
                .padding(vertical = 18.dp, horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            SetImage(
                imageUrl = categoryImage,
                Modifier
                    .size(76.dp)
            )
            Spacer(modifier = Modifier.padding(start = 12.dp))
            Column {
                Text(
                    text = categoryName, style = ZaveTypography.bodySmall.copy(color = black)
                )
                Spacer(modifier = Modifier.padding(top = 8.dp))
                GoalRewardItem("Get ", reward, " Cashback Reward!")
            }
        }
    }
}

@Preview
@Composable
fun CreateGoalHeaderPreview() {
    CreateGoalHeader("", "Apple Inc.", "", "Iphone", "10%")
}