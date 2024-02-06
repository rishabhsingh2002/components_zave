package com.example.componentszave.ui.components.goal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.ui.components.common.SetImage
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_grey_dark_primary

@Composable
fun TopProductsItem(
    imageUrl: String,
    productName: String,
    price: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SetImage(imageUrl = imageUrl, modifier = Modifier.wrapContentSize())
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(
            text = productName,
            style = ZaveTypography.headlineSmall,
            color = dark_theme_grey_dark_primary
        )
        Spacer(modifier = Modifier.padding(top = 4.dp))
        Text(
            text = price,
            style = ZaveTypography.bodySmall.copy(fontSize = 14.sp)
        )
    }
    
}

@Preview
@Composable
fun TopProductsItemPreview() {
    TopProductsItem("", "iPhone 15 Pro", "1,40,000")
}