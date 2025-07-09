package com.vobot.rentals.feature.home.viewModel

import androidx.lifecycle.ViewModel
import com.vobot.rentals.core.data.repository.CarouselImageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(private  val carouselImageRepositoryImpl: CarouselImageRepository) : ViewModel() {
    private val _carouselImageState = MutableStateFlow(carouselImageRepositoryImpl.showCarosalImage)
    val carouselImageState = _carouselImageState.asStateFlow()


}