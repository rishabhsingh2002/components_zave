package com.example.componentszave.ui.components.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentszave.R


@Composable
fun TopNavigation(
    onClick: () -> Unit
) {
    Box(
        Modifier
            .padding(top = 16.dp, bottom = 12.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "Back",
            Modifier.clickable { onClick() })
    }

}

@Preview
@Composable
fun TopNavigationPreview() {
    TopNavigation() {}
}