package com.moviles.examenmoviles.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomBar(
    selected: String,
    onItemSelected: (String) -> Unit
) {
    NavigationBar {

        NavigationBarItem(
            selected = selected == "home",
            onClick = { onItemSelected("home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = selected == "reservations",
            onClick = { onItemSelected("reservations") },
            icon = { Icon(Icons.Default.DateRange, contentDescription = "Reservations") },
            label = { Text("Reservations") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    BottomBar(
        selected = "home",
        onItemSelected = {}
    )
}