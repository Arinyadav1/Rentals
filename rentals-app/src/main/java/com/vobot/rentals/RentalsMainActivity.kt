package com.vobot.rentals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.vobot.rentals.component.AppRoot
import com.vobot.rentals.designsystem.theme.RentalsTheme

class RentalsMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RentalsTheme {
                AppRoot()
            }
        }
    }
}


