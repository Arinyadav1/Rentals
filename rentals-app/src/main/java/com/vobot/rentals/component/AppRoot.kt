package com.vobot.rentals.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.vobot.rentals.designsystem.component.Destination
import com.vobot.rentals.designsystem.component.RentalsBottomAppBar
import com.vobot.rentals.designsystem.component.RentalsScaffold
import com.vobot.rentals.navigation.NavGraphRoute
import com.vobot.rentals.navigation.RootNavHost

@Composable
fun AppRoot(
    modifier: Modifier = Modifier
){
    val navController = rememberNavController()

    RentalsScaffold(
        modifier = modifier,
        bottomBar = {
            RentalsBottomAppBar(
                navController = navController,
                menuItem = listOf(
                    Destination(NavGraphRoute.HOME, "Home", Icons.Outlined.Home, Icons.Default.Home),
                    Destination(NavGraphRoute.FAVORITE, "Favorite", Icons.Outlined.FavoriteBorder, Icons.Default.Favorite),
                    Destination(NavGraphRoute.CART, "Cart", Icons.Outlined.ShoppingCart, Icons.Default.ShoppingCart),
                    Destination(NavGraphRoute.CALENDER, "Calender", Icons.Outlined.DateRange, Icons.Default.DateRange),
                    Destination(NavGraphRoute.PROFILE, "Profile", Icons.Outlined.Person, Icons.Default.Person)
                )
            )
        }
    ){ paddingValues ->
        RootNavHost(
            navController = navController,
        )
    }
}
