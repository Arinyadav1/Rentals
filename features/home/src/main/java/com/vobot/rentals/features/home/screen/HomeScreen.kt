package com.vobot.rentals.features.home.screen


import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vobot.rentals.features.home.R
import com.vobot.rentals.features.search.screen.SearchScreen


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            Column(
                modifier.fillMaxWidth()
                    .background(Color.Cyan),
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {
                CenterAlignedTopAppBar(
                    windowInsets = TopAppBarDefaults.windowInsets,
                    scrollBehavior = scrollBehavior,
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Cyan,
                        titleContentColor = MaterialTheme.colorScheme.onBackground
                    ),
                    title = {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                modifier.fillMaxWidth(.95f),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                IconButton(onClick = {}) {
                                    Icon(
                                        Icons.Default.Menu,
                                        contentDescription = "menu"
                                    )
                                }

                                Text(
                                    text = stringResource(R.string.app_name),
                                    style = MaterialTheme.typography.titleLarge,
                                    color = MaterialTheme.colorScheme.onBackground
                                )

                                IconButton(onClick = {}) {
                                    Icon(
                                        Icons.Outlined.Notifications,
                                        contentDescription = "notifications"
                                    )
                                }
                            }
                        }
                    })

                Box(
                    modifier.padding(top = 10.dp)
                ){
                ElevatedCard(
                    modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {}
                        .fillMaxWidth(.87f)
                        .height(48.dp)
                        .padding(bottom = 10.dp)
                        .border(.0.dp, Color.Gray, CircleShape),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary),
                    shape = CircleShape,
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp)
                ) {
                    Box(
                        modifier
                            .fillMaxSize()
                            .padding(start = 13.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(
                            modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {

                            Icon(
                                Icons.Outlined.Search,
                                contentDescription = "search",
                            )

                            Box(
                                modifier
                                    .fillMaxWidth()
                                    .padding(start = 20.dp),
                            ) {
                                Text(
                                    text = "Search",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }

                        }
                    }
                }
            }
        },

        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                contentColor = MaterialTheme.colorScheme.onBackground,
                tonalElevation = 0.dp
            ) {

                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(.9f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {

                        TextButton(
                            onClick = {},
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    Icons.Outlined.Home,
                                    contentDescription = "Home",
                                    tint = MaterialTheme.colorScheme.onBackground
                                )

                                Text(
                                    text = stringResource(R.string.home),
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        }

                        TextButton(
                            onClick = {},
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    Icons.Outlined.FavoriteBorder,
                                    contentDescription = "Favorite",
                                    tint = MaterialTheme.colorScheme.onBackground
                                )

                                Text(
                                    text = stringResource(R.string.favorite),
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        }

                        TextButton(
                            onClick = {},
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    Icons.Outlined.ShoppingCart,
                                    contentDescription = "cart",
                                    tint = MaterialTheme.colorScheme.onBackground

                                )

                                Text(
                                    text = stringResource(R.string.cart),
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        }

                        TextButton(
                            onClick = {},
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    Icons.Outlined.Person,
                                    contentDescription = "profile",
                                    tint = MaterialTheme.colorScheme.onBackground

                                )

                                Text(
                                    text = stringResource(R.string.profile),
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        }
                    }
                }
            }
        }) { innerPadding ->
        Box(
            modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {

            LazyColumn {
                items(1){
                    Text(
                        text = "Main Content"
                    )
                }
            }

        }
    }
}




