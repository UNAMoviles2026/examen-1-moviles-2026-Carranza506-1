package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.Image
import com.moviles.examenmoviles.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.data.Space
import com.moviles.examenmoviles.ui.components.AvailabilityBadge
import com.moviles.examenmoviles.ui.components.BottomBar
import com.moviles.examenmoviles.ui.components.PriceText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    space: Space,
    onNavigateHome: () -> Unit
) {

    var selectedTab by remember { mutableStateOf("home") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(space.name) }
            )
        },
        bottomBar = {
            BottomBar(
                selected = selectedTab,
                onItemSelected = { route ->
                    selectedTab = route

                    if (route == "home") {
                        onNavigateHome()
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.coworking),
                contentDescription = "Space image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(space.description)
            Text("Location: ${space.location}")
            Text("Capacity: ${space.capacity}")

            PriceText(space.pricePerHour)
            AvailabilityBadge(space.available)

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { }) {
                Text("Reserve")
            }
        }
    }
}
