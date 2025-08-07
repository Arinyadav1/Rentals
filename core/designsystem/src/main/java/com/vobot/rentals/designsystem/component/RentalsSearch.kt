package com.vobot.rentals.designsystem.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RentalsSearch(modifier: Modifier = Modifier) {
    val materialColor = MaterialTheme.colorScheme

    Box(
        contentAlignment = Alignment.Center,
    ) {
        ElevatedCard(
            modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ) {}
                .fillMaxWidth(.87f)
                .height(48.dp)
                .padding(bottom = 10.dp)
                .border(.0.dp, Color.Gray, CircleShape),
            colors = CardDefaults.cardColors(materialColor.surfaceContainerLowest),
            shape = CircleShape,
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp),
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(start = 13.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        Icons.Outlined.Search,
                        contentDescription = "search",
                        tint = materialColor.onSurface,
                    )

                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp),
                    ) {
                        Text(
                            text = "Search",
                            style = MaterialTheme.typography.bodyLarge,
                            color = materialColor.onSurface,
                        )
                    }
                }
            }
        }
    }
}
