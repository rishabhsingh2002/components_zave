package com.example.componentszave

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.componentszave.ui.components.brands.BrandsDetailItem
import com.example.componentszave.ui.components.goal.GoalCard
import com.example.componentszave.ui.theme.dark_theme_blue_primary

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoalCard(
                "My Iphone",
                "Apple Inc.",
                "",
                "Iphone",
                "",
                "8%",
                dark_theme_blue_primary,
                "25%",
                5,
                2f,
                "₹ 50,000",
                "₹ 10,000",
                "05/09/2024"
            ) {}
        }
    }
}