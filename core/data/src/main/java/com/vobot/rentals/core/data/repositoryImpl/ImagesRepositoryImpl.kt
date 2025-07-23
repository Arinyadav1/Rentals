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

        Occasion("Pre-Wedding","https://resourcesmanager.github.io./Images/Occasion/pre-wedding.jpg"),
        Occasion("Wedding","https://resourcesmanager.github.io./Images/Occasion/wedding.jpg"),
        Occasion("Engagement","https://resourcesmanager.github.io./Images/Occasion/Engagement.jpg"),
        Occasion("Mehendi","https://resourcesmanager.github.io./Images/Occasion/mehndi.jpg"),
        Occasion("Haldi","https://resourcesmanager.github.io./Images/Occasion/haldi.jpg"),
        Occasion("Reception","https://resourcesmanager.github.io./Images/Occasion/reception.jpg"),
        Occasion("Clubbing","https://resourcesmanager.github.io./Images/Occasion/Clubbing.jpg"),
        Occasion("Festival Theme Party","https://resourcesmanager.github.io./Images/Occasion/Festival%20Theme%20Party.jpg"),
        Occasion("New Year Party","https://resourcesmanager.github.io./Images/Occasion/new%20year.jpg"),
        Occasion("Farewell","https://resourcesmanager.github.io./Images/Occasion/farewell.jpg"),
        Occasion("Professional Meeting","https://resourcesmanager.github.io./Images/Occasion/Professional%20Meeting.jpg"),
        Occasion("Placement Day Corporate Looks","https://resourcesmanager.github.io./Images/Occasion/Placement%20Day%20Corporate%20Looks.jpg"),
        )

}