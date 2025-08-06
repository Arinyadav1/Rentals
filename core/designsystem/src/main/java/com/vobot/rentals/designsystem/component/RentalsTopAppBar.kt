package com.vobot.rentals.designsystem.component

import android.icu.text.StringSearch
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RentalsTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    searchBar: Boolean = false,
    navigationIcon: ImageVector? = null,
    notificationIcon: ImageVector? = null,
    navigationOnClick: () -> Unit = {},
    notificationOnClick: () -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior? = null,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary,
        titleContentColor = MaterialTheme.colorScheme.primary,
        scrolledContainerColor = MaterialTheme.colorScheme.primary
    ),
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(colors.containerColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CenterAlignedTopAppBar(
            scrollBehavior = scrollBehavior,
            windowInsets = WindowInsets.systemBars,
            colors = colors,
            title = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth().padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        if (navigationIcon != null) {
                            IconButton(
                                onClick = { navigationOnClick() },
                            ) {
                                Icon(
                                    navigationIcon,
                                    contentDescription = "menu",
                                    tint = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        }

                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onPrimary
                        )

                        if (notificationIcon != null) {
                            IconButton(onClick = { notificationOnClick() }) {
                                Icon(
                                    notificationIcon,
                                    contentDescription = "notifications",
                                    tint = MaterialTheme.colorScheme.onPrimary

                                )
                            }
                        }
                    }
                }
            }
        )

        if (searchBar) {
            RentalsSearch()
        }
    }
}