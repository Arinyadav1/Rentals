package com.vobot.rentals.navigation

import android.view.Menu
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vobot.rentals.feature.calender.screen.CalenderScreen
import com.vobot.rentals.feature.cart.screen.CartScreen
import com.vobot.rentals.feature.home.screen.HomeScreen
import com.vobot.rentals.feature.profile.screen.ProfileScreen

@Composable
fun MenuBarNavHost(
    modifier: Modifier = Modifier,
    navController : NavHostController,
){
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = MainNavGraphRoute.HOME
    ) {
        composable(
            route = MainNavGraphRoute.HOME,
        ) {
            HomeScreen()
        }
        composable(
            route = MainNavGraphRoute.PROFILE,
        ) {
            ProfileScreen()
        }
        composable(
            route = MainNavGraphRoute.CART,
        ) {
            CartScreen()
        }
        composable(
            route = MainNavGraphRoute.CALENDER,
        ) {
            CalenderScreen()
        }
        composable(
            route = MainNavGraphRoute.FAVORITE,
        ) {

        }


    }

}