package com.example.componentszave.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.componentszave.R

// Set of Material typography styles to start with
val ZaveTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.clash_display_medium, FontWeight.W500)),
        fontSize = 32.sp,
        lineHeight = 20.sp,
        color = white
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.clash_display_medium, FontWeight.W500)),
        fontSize = 18.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.36.sp,
        color = white
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.clash_display_medium, FontWeight.W500)),
        fontSize = 16.sp,
        color = white
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.outfit_regular, FontWeight.W400)),
        fontSize = 18.sp,
        lineHeight = 23.4.sp,
        color = dark_theme_grey_primary,
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.outfit_regular, FontWeight.W400)),
        fontSize = 16.sp,
        color = dark_theme_grey_secondary
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.outfit_regular, FontWeight.W400)),
        fontSize = 14.sp,
        color = white
    ),
        labelSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.outfit_extra_light, FontWeight.W400)),
        fontSize = 10.sp,
        color = white
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_semi_bold, FontWeight.W400)),
        fontSize = 16.sp,
        color = white
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_regular, FontWeight.W400)),
        fontSize = 14.sp,
        color = white
    ),
    titleSmall =  TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_medium, FontWeight.W400)),
        fontSize = 10.sp,
        color = white
    ),
)