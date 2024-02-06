package com.example.componentszave.ui.components.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.white


@Composable
fun ProfileDetailItem(title: String, onCLick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onCLick }
            .padding(start = 16.dp, end = 24.dp, top = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
    )
    {
        Text(
            text = title,
            style = ZaveTypography.headlineMedium.copy(white),
            modifier = Modifier.weight(1f)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "",
        )
    }
}

@Preview
@Composable
fun ProfileItemPreview() {
    ProfileDetailItem("Personal Details") {
    }

}