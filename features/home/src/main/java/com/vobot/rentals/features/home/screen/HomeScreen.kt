package com.vobot.rentals.features.home.screen


import android.R.attr.onClick
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material3.Card
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import com.vobot.rentals.features.home.R
import com.vobot.rentals.features.search.screen.SearchScreen
import kotlinx.coroutines.delay
import kotlin.collections.listOf
import kotlin.math.absoluteValue


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
                modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                CenterAlignedTopAppBar(
                    windowInsets = TopAppBarDefaults.windowInsets,
                    scrollBehavior = scrollBehavior,
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background,
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
                                        Icons.Default.Menu, contentDescription = "menu"
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
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary),
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
                                )

                                Box(
                                    modifier
                                        .fillMaxWidth()
                                        .padding(start = 20.dp),
                                ) {
                                    Text(
                                        text = "Search", style = MaterialTheme.typography.bodyLarge
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
                    ){
                        CarouselCard(modifier)

                        GenderRow(modifier)
                    }
                }
            }

        }
    }
}


@Composable
private fun CarouselCard(modifier: Modifier) {

    val images = listOf(
        "https://fastly.picsum.photos/id/6/1000/500.jpg?hmac=6f7s_24z1XgQ6QElGrW4fwsRKLIfmuWowrecEh86nbo",
        "https://fastly.picsum.photos/id/858/1000/500.jpg?hmac=FZDw6ZCjfr0ZvTzR8qt_mPh6ojXHYqkUeDqfIjFtApU",
        "https://fastly.picsum.photos/id/731/1000/500.jpg?hmac=aGhjPlHv_FuXmnDEuX-bHarVupjAZmVwwI1Bi5g7GFw",
        "https://fastly.picsum.photos/id/700/1000/500.jpg?hmac=VBA1B3YbuCIYGXpWIlqLA6tZHHIl6qQWx6Y0wm3L_tw",
        "https://fastly.picsum.photos/id/819/1000/500.jpg?hmac=NFbEoH6UbZ3MprU6NT-kqg_DAVw4Co3lp4cxdkXehzE"
    )

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


    HorizontalPager(
        state = pagerState,
        pageSpacing = (-35).dp,
        contentPadding = PaddingValues(horizontal = 30.dp),

        ) { page ->

        ElevatedCard(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(
                pressedElevation = 10.dp, defaultElevation = 8.dp
            ),

            modifier = modifier
                .fillMaxWidth(1f)
                .padding(horizontal = 10.dp)
                .height(180.dp)
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
            AsyncImage(
                model = images[page % images.size],
                contentDescription = "image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
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
fun GenderRow(modifier: Modifier) {

    val genders = remember {
        listOf(
            R.string.man,
            R.string.woman,
            R.string.boy,
            R.string.girl,
        )
    }


    Column(
        modifier.fillMaxWidth(.95f),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier.fillMaxWidth(.9f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.gender_category),
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = stringResource(R.string.see_all),
                style = MaterialTheme.typography.labelMedium
            )
        }

        LazyRow(
            modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items(genders.size) { it ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ElevatedCard(
                        modifier
                            .padding(5.dp)
                            .size(height = 160.dp, width = 130.dp)
                    ) {

                    }

                    Text(
                        text = stringResource(genders[it]),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}




