package com.vobot.rentals.feature.home.di

import com.vobot.rentals.feature.home.viewModel.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module{
    viewModelOf(::HomeViewModel)
}