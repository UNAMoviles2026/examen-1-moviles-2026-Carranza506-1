package com.moviles.examenmoviles.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun PriceText(price: Double) {
    Text(
        text = "$$price / hour",
        style = MaterialTheme.typography.bodyMedium
    )
}