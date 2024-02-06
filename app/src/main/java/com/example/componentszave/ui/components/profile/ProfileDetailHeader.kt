package com.example.componentszave.ui.components.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.componentszave.R
import com.example.componentszave.ui.components.common.CircularImage
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_grey_secondary
import com.example.componentszave.ui.theme.dark_theme_grey_tertiary

@Composable
fun ProfileDetailHeader(
    userName: String,
    ageAndGender: String,
    phoneNumber: String,
    imageUrl: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(dark_theme_grey_tertiary)
            .padding(vertical = 24.dp)
            .fillMaxWidth()
    ) {
        CircularImage(imageUrl)
        Spacer(Modifier.padding(top = 16.dp))
        Text(
            text = userName, style = ZaveTypography.displayMedium,
        )
        Spacer(Modifier.padding(top = 4.dp))
        Text(
            text = ageAndGender, style = ZaveTypography.headlineSmall,
        )
        Spacer(Modifier.padding(top = 4.dp))
        Text(
            text = phoneNumber,
            style = ZaveTypography.headlineSmall.copy(dark_theme_grey_secondary)
        )
    }
}

@Preview
@Composable
fun ProfileDetailHeaderPreview() {
    ProfileDetailHeader(
        "Varun Sharma",
        "23 year • Male",
        "+91 9988389464",
        "https://t4.ftcdn.net/jpg/03/64/21/11/360_F_364211147_1qgLVxv1Tcq0Ohz3FawUfrtONzz8nq3e.jpg"
    )
}