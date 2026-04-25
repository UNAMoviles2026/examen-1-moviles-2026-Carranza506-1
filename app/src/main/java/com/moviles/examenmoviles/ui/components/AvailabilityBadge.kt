package com.moviles.examenmoviles.ui.components


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AvailabilityBadge(isAvailable: Boolean) {
    val text = if (isAvailable) "Available" else "Not Available"
    val color = if (isAvailable) Color(0xFF16A34A) else Color(0xFFDC2626)

    Text(
        text = text,
        color = color
    )
}