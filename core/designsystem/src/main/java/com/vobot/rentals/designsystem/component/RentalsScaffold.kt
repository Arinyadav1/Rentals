package com.vobot.rentals.designsystem.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun RentalsScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    containerColor: Color = MaterialTheme.colorScheme.surfaceContainerLowest,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        containerColor = containerColor,
        contentColor = contentColor,
        modifier = modifier,
        topBar = { topBar() },
        bottomBar = { bottomBar() },
    ) { innerPadding ->
        content(innerPadding)
    }
}
