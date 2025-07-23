package com.vobot.rentals.feature.home.screen


import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomAppBarScrollBehavior
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.ImageLoader
import coil.compose.SubcomposeAsyncImage
import coil.request.CachePolicy
import com.vobot.rentals.feature.home.R
import com.vobot.rentals.feature.home.viewModel.HomeViewModel
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel
import kotlin.math.absoluteValue


@RequiresApi(Build.VERSION_CODES.HONEYCOMB_MR2)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = koinViewModel(),
) {

    val scrollBehaviorTop = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    val materialColor = MaterialTheme.colorScheme

    Scaffold(
        modifier
            .nestedScroll(scrollBehaviorTop.nestedScrollConnection)
            .windowInsetsPadding(WindowInsets.navigationBars),
        containerColor = materialColor.surfaceBright,
        contentColor = materialColor.onSurface,

        topBar = {
            Column(
                modifier.fillMaxWidth().background(materialColor.primary),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CenterAlignedTopAppBar(
                    scrollBehavior = scrollBehaviorTop,
                    windowInsets = WindowInsets.systemBars,
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = materialColor.primary,
                        titleContentColor = materialColor.onPrimary,
                        scrolledContainerColor = materialColor.primary
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

                                IconButton(
                                    onClick = {},
                                ) {
                                    Icon(
                                        Icons.Default.Menu, contentDescription = "menu"
                                    )
                                }

                                Text(
                                    text = stringResource(R.string.app_name),
                                    style = MaterialTheme.typography.titleLarge,
                                    color = materialColor.onPrimary
                                )

                                IconButton(onClick = {}) {
                                    Icon(
                                        Icons.Outlined.Notifications,
                                        contentDescription = "notifications"
                                    )
                                }
                            }
                        }
                    }
                )
                SearchBar(modifier)
            }
        },


        bottomBar = {
            BottomBar(modifier)
        }


    ) { innerPadding ->
        Box(
            modifier
                .fillMaxSize()
                .padding(innerPadding), contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(
                flingBehavior = ScrollableDefaults.flingBehavior()
            ) {

                item {
                    Column(
                        modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CarouselCard(modifier, homeViewModel)

                        GenderRow(modifier, homeViewModel)

                        Favorite(modifier, homeViewModel)

                        Occasion(modifier, homeViewModel)
                    }
                }

            }
        }
    }
}


@Composable
internal fun SearchBar(modifier: Modifier) {

    val materialColor = MaterialTheme.colorScheme

    Box(
         contentAlignment = Alignment.Center
    ) {
        ElevatedCard(
            modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }) {}
                .fillMaxWidth(.87f)
                .height(48.dp)
                .padding(bottom = 10.dp)
                .border(.0.dp, Color.Gray, CircleShape),
            colors = CardDefaults.cardColors(materialColor.surfaceBright),
            shape = CircleShape,
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp)) {
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
                        tint = materialColor.onSurface
                    )


                    Box(
                        modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp),
                    ) {
                        Text(
                            text = "Search",
                            style = MaterialTheme.typography.bodyLarge,
                            color = materialColor.onSurface
                        )
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BottomBar(modifier: Modifier) {

    val materialColor = MaterialTheme.colorScheme

    val interactionSource = remember { MutableInteractionSource() }

    val home by remember { mutableIntStateOf(R.string.home) }
    val favorite by remember { mutableIntStateOf(R.string.favorite) }
    val cart by remember { mutableIntStateOf(R.string.cart) }
    val calendar by remember { mutableIntStateOf(R.string.calendar) }
    val profile by remember { mutableIntStateOf(R.string.profile) }

    var changeState by remember { mutableIntStateOf(home) }

//    val stableColor = colorResource(R.color.black)
//    val changingColor = colorResource(R.color.black)

    BottomAppBar(
        modifier = modifier
            .height(60.dp)
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                drawLine(
                    color = materialColor.outlineVariant,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = strokeWidth
                )
            },
        contentPadding = PaddingValues(0.dp),
        containerColor = materialColor.surfaceContainerLow,
        contentColor = materialColor.onSurface,
        tonalElevation = 10.dp,
    ) {

        Column(
            modifier.padding(top = 5.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth(.85f)
                        .fillMaxHeight(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {


                    Column(
                        modifier.clickable(
                            indication = null, interactionSource = interactionSource
                        ) {
                            changeState = home
                        }, horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = if (changeState == home) Icons.Filled.Home else Icons.Outlined.Home,
                            contentDescription = "home",
                            tint = materialColor.onSurface
                        )

                        Text(
                            text = stringResource(home),
                            style = MaterialTheme.typography.labelSmall,
                            color = materialColor.onSurface
                        )
                    }

                    Column(
                        modifier.clickable(
                            indication = null, interactionSource = interactionSource
                        ) {
                            changeState = favorite
                        }, horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = if (changeState == favorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "favorite",
                            tint = materialColor.onSurface
                        )

                        Text(
                            text = stringResource(favorite),
                            style = MaterialTheme.typography.labelSmall,
                            color = materialColor.onSurface
                        )
                    }

                    Column(
                        modifier.clickable(
                            indication = null, interactionSource = interactionSource
                        ) {
                            changeState = cart
                        }, horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            imageVector = if (changeState == cart) Icons.Filled.ShoppingCart else Icons.Outlined.ShoppingCart,
                            contentDescription = "cart",
                            tint = materialColor.onSurface
                        )

                        Text(
                            text = stringResource(cart),
                            style = MaterialTheme.typography.labelSmall,
                            color = materialColor.onSurface
                        )
                    }

                    Column(
                        modifier.clickable(
                            indication = null, interactionSource = interactionSource
                        ) {
                            changeState = calendar
                        }, horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            imageVector = if (changeState == calendar) Icons.Filled.DateRange else Icons.Outlined.DateRange,
                            contentDescription = "calendar",
                            tint = materialColor.onSurface

                        )

                        Text(
                            text = stringResource(R.string.calendar),
                            style = MaterialTheme.typography.labelSmall,
                            color = materialColor.onSurface
                        )
                    }

                    Column(
                        modifier.clickable(
                            indication = null, interactionSource = interactionSource
                        ) {
                            changeState = profile
                        }, horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            imageVector = if (changeState == profile) Icons.Filled.Person else Icons.Outlined.Person,
                            contentDescription = "profile",
                            tint = materialColor.onSurface

                        )

                        Text(
                            text = stringResource(R.string.profile),
                            style = MaterialTheme.typography.labelSmall,
                            color = materialColor.onSurface
                        )
                    }
                }
            }
        }
    }
}


@SuppressLint("ConfigurationScreenWidthHeight")
@RequiresApi(Build.VERSION_CODES.HONEYCOMB_MR2)
@Composable
private fun CarouselCard(modifier: Modifier, homeViewModel: HomeViewModel) {

    val context = LocalContext.current

    val images by homeViewModel.carouselImageState.collectAsState()

    val max = Int.MAX_VALUE
    val pagerState = rememberPagerState(initialPage = max / 2, pageCount = { max })

    val pagerIsDragged by pagerState.interactionSource.collectIsDraggedAsState()

    val pageInteractionSource = remember { MutableInteractionSource() }
    val pageIsPressed by pageInteractionSource.collectIsPressedAsState()

    val autoAdvance = !pagerIsDragged && !pageIsPressed

    if (autoAdvance) {
        LaunchedEffect(pagerState, pageInteractionSource) {
            while (true) {
                delay(3000)
                val nextPage = (pagerState.currentPage + 1)
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }

    val configuration = LocalConfiguration.current
    val isTablet = configuration.screenWidthDp >= 600


    HorizontalPager(
        state = pagerState,
        pageSpacing = (-35).dp,
        contentPadding = PaddingValues(start = 30.dp, end = 30.dp, top = 10.dp),

        ) { page ->

        ElevatedCard(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(
                pressedElevation = 10.dp, defaultElevation = 8.dp
            ),

            modifier = modifier
                .fillMaxWidth(1f)
                .padding(horizontal = 10.dp)
                .clickable(
                    interactionSource = pageInteractionSource, indication = LocalIndication.current
                ) {

                }

                .graphicsLayer {
                    val pageOffset =
                        ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

                    scaleY = lerp(
                        start = 0.85f, stop = 1f, fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                    scaleX = lerp(
                        start = 0.85f, stop = 1f, fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                    alpha = lerp(
                        start = 0.4f, stop = 1f, fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                },
        ) {
            val imageLoader =
                ImageLoader.Builder(context).crossfade(true).diskCachePolicy(CachePolicy.ENABLED)
                    .build()

            SubcomposeAsyncImage(
                model = images[page % images.size],
                loading = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp), strokeWidth = 2.dp
                        )
                    }
                },
                error = {

                    Box(
                        modifier = Modifier.fillMaxSize(.9f),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = stringResource(R.string.image_error_handle),
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Center
                        )
                    }

                },
                contentDescription = "image",
                imageLoader = imageLoader,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(if (isTablet) 1280f / 300f else 1280f / 720f)
            )
        }
    }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp, top = 5.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        repeat(images.size) { iteration ->
            val color =
                if ((pagerState.currentPage % images.size) == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(7.dp)
            )
        }
    }
}


@Composable
fun GenderRow(modifier: Modifier, homeViewModel: HomeViewModel) {

    val genderImages by homeViewModel.genderImageState.collectAsState()

    val context = LocalContext.current

    Column(
        modifier
            .fillMaxWidth(.95f)
            .padding(top = 5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier.fillMaxWidth(.97f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.gender_category),
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = stringResource(R.string.see_all), style = MaterialTheme.typography.bodySmall
            )
        }

        LazyRow(
            modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            items(genderImages) { it ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ElevatedCard(
                        modifier
                            .padding(5.dp)
                            .size(height = 100.dp, width = 100.dp)
                    ) {

                        val imageLoader = ImageLoader.Builder(context).crossfade(true)
                            .diskCachePolicy(CachePolicy.ENABLED).build()

                        SubcomposeAsyncImage(
                            model = it.image,
                            loading = {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.size(20.dp), strokeWidth = 2.dp
                                    )
                                }
                            },
                            error = {

                                Box(
                                    modifier = Modifier.fillMaxSize(.9f),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    Text(
                                        text = stringResource(R.string.image_error_handle),
                                        style = MaterialTheme.typography.bodySmall,
                                        textAlign = TextAlign.Center
                                    )
                                }

                            },
                            contentDescription = "genderImage",
                            imageLoader = imageLoader,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.fillMaxWidth()
                        )

                    }

                    Text(
                        text = it.gender, style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}


@Composable
fun Favorite(modifier: Modifier, homeViewModel: HomeViewModel) {

    val favoriteImages by homeViewModel.favoriteImageState.collectAsState()

    val context = LocalContext.current

    Column(
        modifier
            .fillMaxWidth(.95f)
            .padding(top = 20.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier.fillMaxWidth(.97f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.favorite_category),
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = stringResource(R.string.see_all), style = MaterialTheme.typography.bodySmall
            )
        }

        LazyRow(
            modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween

        ) {
            items(favoriteImages) { it ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ElevatedCard(
                        modifier
                            .padding(5.dp)
                            .size(height = 160.dp, width = 130.dp)
                    ) {

                        val imageLoader = ImageLoader.Builder(context).crossfade(true)
                            .diskCachePolicy(CachePolicy.ENABLED).build()

                        SubcomposeAsyncImage(
                            model = it.image,
                            loading = {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.size(20.dp), strokeWidth = 2.dp
                                    )
                                }
                            },
                            error = {

                                Box(
                                    modifier = Modifier.fillMaxSize(.9f),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    Text(
                                        text = stringResource(R.string.image_error_handle),
                                        style = MaterialTheme.typography.bodySmall,
                                        textAlign = TextAlign.Center
                                    )
                                }

                            },
                            contentDescription = "genderImage",
                            imageLoader = imageLoader,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.fillMaxWidth()
                        )

                    }

                    Text(
                        text = it.name, style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}


@SuppressLint("ConfigurationScreenWidthHeight")
@RequiresApi(Build.VERSION_CODES.HONEYCOMB_MR2)
@Composable
fun Occasion(modifier: Modifier, homeViewModel: HomeViewModel) {

    val occasion by homeViewModel.occasionState.collectAsState()

    val context = LocalContext.current

    val materialColor = MaterialTheme.colorScheme

    ElevatedCard(
        modifier = modifier.padding(bottom = 10.dp),
        colors = CardDefaults.elevatedCardColors(materialColor.primaryContainer),

    ) {
        Column(
            modifier
                .fillMaxWidth(.95f)
                .clip(RoundedCornerShape(10.dp))
                .padding(top = 10.dp)
                .heightIn(max = 2000.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier.fillMaxWidth(.9f), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.occasion_category),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = modifier.padding(bottom = 7.dp)
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
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Card(
                            modifier
                                .padding(5.dp)
                                .size(100.dp)
                        ) {

                            val imageLoader = ImageLoader.Builder(context).crossfade(true)
                                .diskCachePolicy(CachePolicy.ENABLED).build()

                            SubcomposeAsyncImage(
                                model = it.image,
                                loading = {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center,
                                    ) {
                                        CircularProgressIndicator(
                                            modifier = Modifier.size(20.dp), strokeWidth = 2.dp
                                        )
                                    }
                                },
                                error = {

                                    Box(
                                        modifier = Modifier.fillMaxSize(.9f),
                                        contentAlignment = Alignment.Center,
                                    ) {
                                        Text(
                                            text = stringResource(R.string.image_error_handle),
                                            style = MaterialTheme.typography.bodySmall,
                                            textAlign = TextAlign.Center
                                        )
                                    }

                                },
                                contentDescription = "genderImage",
                                imageLoader = imageLoader,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.fillMaxWidth()
                            )

                        }

                        Text(
                            modifier = modifier.width(100.dp),
                            text = it.name,
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}




