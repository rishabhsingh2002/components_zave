package com.example.componentszave.ui.components.goal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.components.brands.GoalRewardItem
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_yellow_primary

@Composable
fun NoGoalsCard() {
    Box(
        Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_no_goals),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(horizontal = 22.dp)
                .fillMaxSize(),
        ) {
            GoalRewardItem(
                "",
                "No Goal to Show!",
                "",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                rewardTextColor = dark_theme_yellow_primary,
                rewardTextSize = 16.sp,
                rewardTextFontFamily = R.font.clash_display_medium,
                containerColor = Color(0xFFFFFFFF).copy(alpha = 0.05f),
                leftIcon = null,
                rightIcon = null
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Whoops!",
                style = ZaveTypography.headlineSmall.copy(
                    fontFamily = FontFamily(Font(R.font.outfit_semi_bold)),
                    fontSize = 12.sp,
                    color = Color(0xFFFFFFFF).copy(alpha = 0.25f)
                )
            )

            Text(
                text = "Looks like you have nothing here at the moment, lets change that! Create your first goal by swiping right on the arrow below!",
                style = ZaveTypography.headlineSmall.copy(
                    fontFamily = FontFamily(Font(R.font.outfit_medium)),
                    fontSize = 12.sp,
                    color = Color(0xFFFFFFFF).copy(alpha = 0.25f)
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun NoGoalsCardPreview() {
    NoGoalsCard()
}