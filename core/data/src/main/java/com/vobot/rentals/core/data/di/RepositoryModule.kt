package com.vobot.rentals.core.data.di

import com.vobot.rentals.core.data.repository.CarouselImageRepository
import com.vobot.rentals.core.data.repositoryImpl.CarouselImageRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val repositoryModule = module {

    singleOf(::CarouselImageRepositoryImpl) { bind<CarouselImageRepository>() }

}