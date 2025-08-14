package com.vobot.rentals.feature.favorite.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.vobot.rentals.designsystem.component.RentalsScaffold
import com.vobot.rentals.designsystem.component.RentalsTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen() {

    RentalsScaffold(
        topBar = {
            RentalsTopAppBar(
                title = "Favorite",
            )
        },
    ) {

    }
}
