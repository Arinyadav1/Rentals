package com.vobot.rentals.features.home.screen


import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
                ) {
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
            contentAlignment = Alignment.TopCenter
        ) {

            LazyColumn {
                items(1) {
                    CarouselCard()
                }
            }

        }
    }
}


@Composable
fun CarouselCard(modifier: Modifier = Modifier) {

   val count = 5

    val pagerState = rememberPagerState(initialPage = count/2, pageCount = { count })

    Column(
    ) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 30.dp),

            ) { page ->
            Card(

                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(pressedElevation = 10.dp, defaultElevation = 8.dp),

                modifier = modifier
                    .fillMaxWidth(1f)
                    .padding(horizontal = 10.dp)
                    .height(200.dp)

                    .graphicsLayer {
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState
                                    .currentPageOffsetFraction
                                ).absoluteValue

                        scaleY = lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, .1f)
                        )
                        scaleX = lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, .1f)
                        )
                    },
            ) {
                AsyncImage(
                    model = "https://fastly.picsum.photos/id/726/1000/400.jpg?hmac=g1e6bkiB6m15QapO6e2MI258HSrVUoymk95nZ5eR8MQ",
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
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }


    }

}




