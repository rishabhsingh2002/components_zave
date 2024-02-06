package com.example.componentszave.ui.components.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentszave.R
import com.example.componentszave.ui.theme.ZaveTypography
import com.example.componentszave.ui.theme.dark_theme_grey_secondary
import com.example.componentszave.ui.theme.dark_theme_yellow_primary


@Composable
fun CommonSlider(
    title: String,
    position: Float = 0f,
    interactionSource: MutableInteractionSource,
    minAmount: String,
    maxAmount: String
) {
    Column(Modifier.fillMaxWidth()) {
        Text(text = title, style = ZaveTypography.headlineSmall, color = dark_theme_grey_secondary)

        Spacer(modifier = Modifier.height(8.dp))

        CustomSlider(position, interactionSource)

        Row {
            Text(
                text = minAmount, style = ZaveTypography.bodyMedium.copy(fontSize = 12.sp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = maxAmount,
                style = ZaveTypography.bodyMedium.copy(fontSize = 12.sp),
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSlider(
    position: Float = 0f, interactionSource: MutableInteractionSource
) {
    var sliderPosition: Float by remember { mutableFloatStateOf(position) }

    Slider(value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 0f..100f,
        interactionSource = interactionSource,
        onValueChangeFinished = {},
        colors = SliderDefaults.colors(
            activeTrackColor = dark_theme_yellow_primary,
            inactiveTrackColor = Color(0xFFFFFFFF).copy(alpha = 0.50f)
        ),
        thumb = {
            Box(
                contentAlignment = Alignment.TopCenter, modifier = Modifier.padding(bottom = 42.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_slider_thumb),
                    contentDescription = ""
                )
                Text(
                    text = "₹${sliderPosition.toInt()}", style = ZaveTypography.titleSmall.copy(
                        color = dark_theme_yellow_primary, fontSize = 12.sp
                    )
                )
            }
        })
}

@Preview
@Composable
fun CustomSliderPreview() {
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    CommonSlider("Set product’s price", 0f, interactionSource, "₹ 20,000", "₹ 1,00,000")
}