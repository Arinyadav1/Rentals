package com.vobot.rentals.feature.home.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vobot.rentals.designsystem.component.RentalsAsyncImage
import com.vobot.rentals.designsystem.component.RentalsNavigationDrawer
import com.vobot.rentals.designsystem.component.RentalsScaffold
import com.vobot.rentals.designsystem.component.RentalsSearch
import com.vobot.rentals.designsystem.component.RentalsTopAppBar
import com.vobot.rentals.feature.home.R
import com.vobot.rentals.feature.home.viewModel.HomeViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.HONEYCOMB_MR2)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = koinViewModel(),
) {
    val scrollBehaviorTop = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    RentalsNavigationDrawer(
        drawerState = drawerState
    ) {
        RentalsScaffold(
            modifier.padding(bottom = 60.dp)
                .nestedScroll(scrollBehaviorTop.nestedScrollConnection)
                .windowInsetsPadding(WindowInsets.navigationBars),
            topBar = {
                RentalsTopAppBar(
                    title = stringResource(R.string.app_name),
                    navigationIcon = Icons.Filled.Menu,
                    notificationIcon = Icons.Outlined.Notifications,
                    navigationOnClick = {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    },
                    scrollBehavior = scrollBehaviorTop,
                    searchBar = { RentalsSearch() },
                )
            },
        ) { innerPadding ->
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.TopCenter,
            ) {
                LazyColumn(
                    flingBehavior = ScrollableDefaults.flingBehavior(),
                ) {
                    item {
                        Column(
                            Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            CarouselCard(homeViewModel = homeViewModel)

                            GenderRow(homeViewModel = homeViewModel)

                            Favorite(homeViewModel = homeViewModel)

                            Occasion(homeViewModel = homeViewModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GenderRow(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
) {
    val genderImages by homeViewModel.genderImageState.collectAsState()

    Column(
        modifier
            .fillMaxWidth(.95f)
            .padding(top = 5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            Modifier.fillMaxWidth(.97f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = stringResource(R.string.gender_category),
                style = MaterialTheme.typography.labelLarge,
            )
            Text(
                text = stringResource(R.string.see_all),
                style = MaterialTheme.typography.bodySmall,
            )
        }

        LazyRow(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            items(genderImages) { it ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    ElevatedCard(
                        Modifier
                            .padding(5.dp)
                            .size(height = 100.dp, width = 100.dp),
                    ) {
                        RentalsAsyncImage(
                            images = it.image,
                        )
                    }

                    Text(
                        text = it.gender,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
        }
    }
}

@Composable
fun Favorite(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
) {
    val favoriteImages by homeViewModel.favoriteImageState.collectAsState()

    Column(
        modifier
            .fillMaxWidth(.95f)
            .padding(top = 20.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            Modifier.fillMaxWidth(.97f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = stringResource(R.string.favorite_category),
                style = MaterialTheme.typography.labelLarge,
            )
            Text(
                text = stringResource(R.string.see_all),
                style = MaterialTheme.typography.bodySmall,
            )
        }

        LazyRow(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            items(favoriteImages) { it ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    ElevatedCard(
                        Modifier
                            .padding(5.dp)
                            .size(height = 160.dp, width = 130.dp),
                    ) {
                        RentalsAsyncImage(
                            images = it.image,
                        )
                    }

                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
        }
    }
}

@SuppressLint("ConfigurationScreenWidthHeight")
@RequiresApi(Build.VERSION_CODES.HONEYCOMB_MR2)
@Composable
fun Occasion(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
) {
    val occasion by homeViewModel.occasionState.collectAsState()

    val context = LocalContext.current

    val materialColor = MaterialTheme.colorScheme

    ElevatedCard(
        modifier = Modifier.padding(10.dp),
        colors = CardDefaults.elevatedCardColors(materialColor.surfaceContainerLow),
    ) {
        Column(
            Modifier
                .fillMaxWidth(.95f)
                .clip(RoundedCornerShape(10.dp))
                .padding(top = 10.dp)
                .heightIn(max = 2000.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                Modifier.fillMaxWidth(.9f),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = stringResource(R.string.occasion_category),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(bottom = 7.dp),
                )
            }

            LazyVerticalGrid(
                columns = GridCells.Adaptive(100.dp),
                userScrollEnabled = false,
                verticalArrangement = Arrangement.SpaceEvenly,
                contentPadding = PaddingValues(8.dp),
            ) {
                items(occasion) { it ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Card(
                            Modifier
                                .padding(5.dp)
                                .size(100.dp),
                        ) {
                            RentalsAsyncImage(
                                images = it.image,
                            )
                        }

                        Text(
                            modifier = Modifier.width(100.dp),
                            text = it.name,
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
    }
}
