package com.vobot.rentals.feature.cart.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.vobot.rentals.designsystem.component.RentalsScaffold
import com.vobot.rentals.designsystem.component.RentalsTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen() {
    RentalsScaffold(
        topBar = {
            RentalsTopBar(
                "Cart"
            )
        }
    ){

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Cart Screen")
        }
    }
}
