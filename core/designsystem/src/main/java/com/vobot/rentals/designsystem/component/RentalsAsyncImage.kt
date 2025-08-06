package com.vobot.rentals.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.SubcomposeAsyncImage
import coil.request.CachePolicy

@Composable
fun RentalsAsyncImage(
    modifier: Modifier = Modifier,
    images: String,
){

    val context = LocalContext.current
    val imageLoader =
        ImageLoader.Builder(context).crossfade(true).diskCachePolicy(CachePolicy.ENABLED)
            .build()

    SubcomposeAsyncImage(
        modifier = modifier,
        model = images,
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
                Icon(
                    imageVector = Icons.Filled.BrokenImage,
                    contentDescription = "Image not loaded",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(40.dp)
                )
            }

        },
        contentDescription = "image",
        imageLoader = imageLoader,
        contentScale = ContentScale.FillBounds,
    )
}
