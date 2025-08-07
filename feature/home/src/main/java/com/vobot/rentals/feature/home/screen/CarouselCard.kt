package com.vobot.rentals.feature.home.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.vobot.rentals.designsystem.component.RentalsAsyncImage
import com.vobot.rentals.feature.home.viewModel.HomeViewModel
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

@SuppressLint("ConfigurationScreenWidthHeight")
@RequiresApi(Build.VERSION_CODES.HONEYCOMB_MR2)
@Composable
internal fun CarouselCard(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
) {
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
        modifier = modifier,
        state = pagerState,
        pageSpacing = (-35).dp,
        contentPadding = PaddingValues(start = 30.dp, end = 30.dp, top = 10.dp),
    ) { page ->

        ElevatedCard(
            shape = RoundedCornerShape(16.dp),
            elevation =
                CardDefaults.cardElevation(
                    pressedElevation = 10.dp,
                    defaultElevation = 8.dp,
                ),
            modifier =
                Modifier
                    .fillMaxWidth(1f)
                    .padding(horizontal = 10.dp)
                    .clickable(
                        interactionSource = pageInteractionSource,
                        indication = LocalIndication.current,
                    ) {}
                    .graphicsLayer {
                        val pageOffset =
                            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

                        scaleY =
                            lerp(
                                start = 0.85f, stop = 1f, fraction = 1f - pageOffset.coerceIn(0f, 1f),
                            )
                        scaleX =
                            lerp(
                                start = 0.85f, stop = 1f, fraction = 1f - pageOffset.coerceIn(0f, 1f),
                            )
                        alpha =
                            lerp(
                                start = 0.4f, stop = 1f, fraction = 1f - pageOffset.coerceIn(0f, 1f),
                            )
                    },
        ) {
            RentalsAsyncImage(
                modifier = Modifier.aspectRatio(if (isTablet) 1280f / 300f else 1280f / 720f),
                images = images[page % images.size],
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
                if ((pagerState.currentPage % images.size) == iteration) {
                    MaterialTheme.colorScheme.onSurfaceVariant
                } else {
                    MaterialTheme.colorScheme.surfaceContainerHighest
                }
            Box(
                modifier =
                    Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(7.dp),
            )
        }
    }
}
