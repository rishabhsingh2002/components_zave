package com.example.componentszave.ui.components.personal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_grey_light_primary
import com.example.componentszave.ui.theme.dark_theme_grey_light_tertiary
import com.example.componentszave.ui.theme.white


@Composable
fun PersonalDetailItem(title: String, value: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 18.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title, style = ZaveTypography.headlineMedium.copy(dark_theme_grey_light_tertiary)
        )
        Spacer(Modifier.height( 8.dp))

        Text(
            text = value,
            style = ZaveTypography.headlineLarge.copy(white),
        )

        Spacer(Modifier.height(18.dp))

        Divider(
            color = dark_theme_grey_light_primary,
            thickness = 1.dp
        )
    }
}

@Preview
@Composable
fun PersonalDetailItemPreview() {
    Column {
        PersonalDetailItem("Name", "Varun Sharma")
        PersonalDetailItem("Name", "Varun Sharma")
        PersonalDetailItem("Name", "Varun Sharma")
        PersonalDetailItem("Name", "Varun Sharma")
    }

}