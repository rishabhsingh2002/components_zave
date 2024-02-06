package com.example.componentszave.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_grey_extra_light_secondary

@Composable
fun FindAnswer() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(dark_theme_grey_extra_light_secondary)
            .padding(horizontal = 24.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.ic_find_answers), contentDescription = "")

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "Find answers to your questions from FAQs or Contact Us →",
            style = ZaveTypography.headlineSmall
        )
    }

}

@Preview
@Composable
fun FindAnswerPreview() {
    FindAnswer()
}