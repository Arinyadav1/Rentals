package com.vobot.rentals.feature.home.viewModel

import androidx.lifecycle.ViewModel
import com.vobot.rentals.core.data.repository.ImagesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(imagesRepositoryImpl: ImagesRepository) : ViewModel() {
    private val _carouselImageState = MutableStateFlow(imagesRepositoryImpl.showCarousalImage)
    val carouselImageState = _carouselImageState.asStateFlow()

    private val _genderImageState = MutableStateFlow(imagesRepositoryImpl.genderImage)
    val genderImageState = _genderImageState.asStateFlow()

    private val _favoriteImageState = MutableStateFlow(imagesRepositoryImpl.favoriteImage)
    val favoriteImageState = _favoriteImageState.asStateFlow()

    private val _occasionState = MutableStateFlow(imagesRepositoryImpl.occasionData)
    val occasionState = _occasionState.asStateFlow()
}
