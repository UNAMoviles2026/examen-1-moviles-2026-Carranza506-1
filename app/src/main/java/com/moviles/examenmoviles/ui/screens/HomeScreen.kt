package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.moviles.examenmoviles.data.mockSpaces
import com.moviles.examenmoviles.ui.components.BottomBar
import com.moviles.examenmoviles.ui.components.SpaceCard
import com.moviles.examenmoviles.ui.theme.ExamenMovilesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onSpaceClick: (Int) -> Unit
) {

    var selectedTab by remember { mutableStateOf("home") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Coworking Spaces") }
            )
        },
        bottomBar = {
            BottomBar(
                selected = selectedTab,
                onItemSelected = { selectedTab = it }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {

            items(mockSpaces) { space ->

                SpaceCard(
                    space = space,
                    onClick = {

                    }
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ExamenMovilesTheme {
        HomeScreen(
            onSpaceClick = {}
        )
    }
}