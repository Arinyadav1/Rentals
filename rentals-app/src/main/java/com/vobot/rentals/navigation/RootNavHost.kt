package com.vobot.rentals.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vobot.rentals.feature.calender.screen.CalenderScreen
import com.vobot.rentals.feature.cart.screen.CartScreen
import com.vobot.rentals.feature.favorite.screen.FavoriteScreen
import com.vobot.rentals.feature.home.screen.HomeScreen
import com.vobot.rentals.feature.profile.screen.ProfileScreen

@Composable
fun RootNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavGraphRoute.HOME
    ) {
        composable(
            route = NavGraphRoute.HOME,
        ) {
            HomeScreen()
        }
        composable(
            route = NavGraphRoute.PROFILE,
        ) {
            ProfileScreen()
        }
        composable(
            route = NavGraphRoute.CART,
        ) {
            CartScreen()
        }
        composable(
            route = NavGraphRoute.CALENDER,
        ) {
            CalenderScreen()
        }
        composable(
            route = NavGraphRoute.FAVORITE,
        ) {
            FavoriteScreen()
        }
    }
}