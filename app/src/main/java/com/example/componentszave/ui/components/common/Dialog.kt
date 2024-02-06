package com.example.componentszave.ui.components.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.ui.components.button.CancelButton
import com.example.componentszave.ui.components.button.PrimaryButton
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.black
import com.example.componentszave.ui.theme.dark_theme_grey_light_primary
import com.example.componentszave.ui.theme.dark_theme_grey_secondary
import com.example.componentszave.ui.theme.white

@Composable
fun Dialog(
    title: String,
    subTitle: String,
    buttonOneText: String,
    buttonTwoText: String,
    buttonOneClick: () -> Unit,
    buttonTwoClick: () -> Unit
) {
    Column(
        Modifier
            .background(black)
            .border(BorderStroke(1.dp, dark_theme_grey_light_primary))
            .padding(24.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(text = title, style = ZaveTypography.headlineLarge, color = white)
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(
                text = subTitle,
                style = ZaveTypography.headlineLarge,
                color = dark_theme_grey_secondary
            )
        }
        Spacer(modifier = Modifier.padding(top = 60.dp))
        Row(
            horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()
        ) {
            CancelButton(text = buttonTwoText) {
                buttonTwoClick()
            }
            Spacer(modifier = Modifier.padding(start = 16.dp))
            PrimaryButton(
                text = buttonOneText,
                fontSize = 14.sp,
                modifier = Modifier
                    .height(40.dp)
                    .width(80.dp),
                showImage = false
            ) {
                buttonOneClick()
            }
        }

    }

}

@Preview
@Composable
fun DialogPreview() {
    Dialog("Tussi ja rahe ho?", "Are you sure you want to log out?", "No", "Yes", {}, {})
}