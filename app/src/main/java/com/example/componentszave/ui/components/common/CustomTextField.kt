package com.example.componentszave.ui.components.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.black
import com.example.componentszave.ui.theme.dark_theme_grey_extra_light_primary
import com.example.componentszave.ui.theme.dark_theme_grey_light_primary
import com.example.componentszave.ui.theme.dark_theme_yellow_primary
import com.example.componentszave.ui.theme.white


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: String,
    modifier: Modifier = Modifier,
    textColor: Color = white,
    placeHolderColor: Color = dark_theme_grey_extra_light_primary,
    textStyle: TextStyle = ZaveTypography.headlineMedium,
    keyboardType: KeyboardType = KeyboardType.Text,
    cursorColor: Color = dark_theme_yellow_primary
) {
    val text by remember { mutableStateOf(value) }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .background(black)
            .border(BorderStroke(1.5.dp, dark_theme_grey_light_primary))
            .fillMaxWidth()
            .height(54.dp)
    ) {
        TextField(
            value = text,
            onValueChange = {
                onValueChange
            },
            textStyle = textStyle.copy(color = textColor),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                cursorColor = cursorColor,
                focusedIndicatorColor = Color.Transparent,
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            placeholder = {
                Text(placeHolder, style = textStyle.copy(color = placeHolderColor))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            )
        )
    }

}

@Preview
@Composable
fun CustomTextFieldPreview() {
    var inputValue by remember { mutableStateOf("") }

    CustomTextField(inputValue, { inputValue = it }, "Enter your Name")
}



