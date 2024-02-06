package com.example.componentszave.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.components.common.CircularImage
import com.example.componentszave.ui.theme.ZaveTypography


@Composable
fun HomeHeader(
    userImage: String, userName: String
) {
    Row(verticalAlignment = Alignment.CenterVertically)
    {
        CircularImage(imageUrl = userImage, modifier = Modifier.size(32.dp))

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = "Hey $userName!", style = ZaveTypography.displaySmall.copy(fontSize = 14.sp))

        Spacer(modifier = Modifier.weight(1f))

        Image(painter = painterResource(id = R.drawable.ic_wallet), contentDescription = "Wallet")


    }
}

@Preview
@Composable
fun HomeHeaderPreview() {
    HomeHeader("", "Rishabh")
}