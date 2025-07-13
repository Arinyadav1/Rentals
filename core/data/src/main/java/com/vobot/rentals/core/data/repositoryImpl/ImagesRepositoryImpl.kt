package com.vobot.rentals.core.data.repositoryImpl

import com.vobot.rentals.core.data.repository.ImagesRepository
import com.vobot.rentals.core.model.entity.FavoriteImage
import com.vobot.rentals.core.model.entity.GenderImage
import com.vobot.rentals.core.model.entity.Occasion

class ImagesRepositoryImpl() : ImagesRepository  {

    override val showCarousalImage = listOf(
        "https://resourcesmanager.github.io./Images/cloth_hang.jpg",
        "https://resourcesmanager.github.io./Images/bride.jpg",
        "https://resourcesmanager.github.io./Images/wedding_sale.jpg",
        "https://resourcesmanager.github.io./Images/bridal_lehnga.jpg",
        "https://resourcesmanager.github.io./Images/kids.jpg",
        "https://resourcesmanager.github.io./Images/rent.jpg"
    )

    override val genderImage = listOf(
        GenderImage("Man","https://resourcesmanager.github.io./Images/GenderImages/Man.jpg"),
        GenderImage("Women","https://resourcesmanager.github.io./Images/GenderImages/Women.jpg"),
        GenderImage("Boy","https://resourcesmanager.github.io./Images/GenderImages/Boy.jpg"),
        GenderImage("Girl","https://resourcesmanager.github.io./Images/GenderImages/Girl.jpg"),
    )

    override val favoriteImage = listOf(
        FavoriteImage("Hoodie", "https://resourcesmanager.github.io./Images/FavoritesImage/Hoodie.jpg")
    )

    override val occasionData = listOf(
        Occasion("Pre-Wedding",""),
        Occasion("Wedding",""),
        Occasion("Engagements ",""),
        Occasion("Mehendi",""),
        Occasion("Haldi",""),
        Occasion("Reception",""),
        Occasion("Farewell",""),
        Occasion("Clubbing",""),
        Occasion("Professional Meeting",""),
        Occasion("Internship/Placement Day (Corporate Looks)",""),

        )

}