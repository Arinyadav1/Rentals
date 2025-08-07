package com.vobot.rentals.core.data.repository

import com.vobot.rentals.core.model.entity.FavoriteImage
import com.vobot.rentals.core.model.entity.GenderImage
import com.vobot.rentals.core.model.entity.Occasion

interface ImagesRepository {
    val showCarousalImage: List<String>

    val genderImage: List<GenderImage>

    val favoriteImage: List<FavoriteImage>

    val occasionData: List<Occasion>
}
