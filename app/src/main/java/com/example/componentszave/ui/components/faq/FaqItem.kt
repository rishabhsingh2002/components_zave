package com.example.componentszave.ui.components.faq

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_grey_light_primary
import com.example.componentszave.ui.theme.dark_theme_grey_medium_primary
import com.example.componentszave.ui.theme.dark_theme_grey_tertiary
import com.example.componentszave.ui.theme.white


@Composable
fun FaqItem(question: String, description: String) {
    val isDescriptionVisible: MutableState<Boolean> = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
    ) {
        Divider(color = dark_theme_grey_light_primary, thickness = 1.dp)
        FaqQuestionItem(question, isDescriptionVisible.value) {
            isDescriptionVisible.value = !isDescriptionVisible.value
        }
        if (isDescriptionVisible.value) {
            FaqDescription(description)
        }
    }
}

@Composable
private fun FaqQuestionItem(
    question: String, isDescriptionVisible: Boolean, onCLick: () -> Unit
) {
    Row(modifier = Modifier
        .clickable { onCLick() }
        .padding(top = 18.dp, bottom = 18.dp, start = 16.dp, end = 22.dp)) {
        Text(
            text = question,
            style = ZaveTypography.headlineMedium.copy(white),
            modifier = Modifier.weight(1f)
        )
        Image(
            painter = painterResource(id = if (isDescriptionVisible) R.drawable.ic_faq_close else R.drawable.ic_faq_open),
            contentDescription = ""
        )
    }
}

@Composable
private fun FaqDescription(description: String) {
    Box(
        modifier = Modifier
            .background(dark_theme_grey_tertiary)
            .padding(vertical = 16.dp, horizontal = 16.dp)
    ) {
        Text(
            text = description,
            style = ZaveTypography.headlineMedium.copy(dark_theme_grey_medium_primary)
        )
    }
}


@Preview
@Composable
fun FaqItemPreview() {
    FaqItem(
        "What is Zave?",
        "\"Zave is a Savings + Credit platform that helps you to accomplish your purchase goals. Our mission is to make you and millions of young people financially aware. We believe there’s a better and more responsible way to manage the finances for your large purchases.\""
    )
}