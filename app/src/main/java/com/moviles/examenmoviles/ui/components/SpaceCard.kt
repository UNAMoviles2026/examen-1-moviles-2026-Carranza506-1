package com.moviles.examenmoviles.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.data.Space
import com.moviles.examenmoviles.R

@Composable
fun SpaceCard(
    space: Space,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Image(
                painter = painterResource(com.moviles.examenmoviles.R.drawable.coworking),
                contentDescription = "Space image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = space.name,
                style = MaterialTheme.typography.titleMedium
            )

            Text(text = space.location)

            Text(text = "Capacity: ${space.capacity}")

            PriceText(space.pricePerHour)

            AvailabilityBadge(space.available)

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                println("CLICKED")
                onClick()
            }) {
                Text("View Details")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpaceCardPreview() {
    val mock = Space(
        id = 1,
        name = "CoWork Central",
        description = "Espacio moderno",
        location = "San José",
        capacity = 10,
        pricePerHour = 8.5,
        available = true,
        imageUrl = ""
    )

    SpaceCard(
        space = mock,
        onClick = {}
    )
}