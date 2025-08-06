package com.vobot.rentals.component

import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.vobot.rentals.designsystem.component.Destination
import com.vobot.rentals.designsystem.component.RentalsBottomAppBar
import com.vobot.rentals.designsystem.component.RentalsScaffold
import com.vobot.rentals.navigation.MainNavGraphRoute
import com.vobot.rentals.navigation.MenuBarNavHost

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
                    Destination(MainNavGraphRoute.HOME, "Home", Icons.Outlined.Home, Icons.Default.Home),
                    Destination(MainNavGraphRoute.FAVORITE, "Favorite", Icons.Outlined.FavoriteBorder, Icons.Default.Favorite),
                    Destination(MainNavGraphRoute.CART, "Cart", Icons.Outlined.ShoppingCart, Icons.Default.ShoppingCart),
                    Destination(MainNavGraphRoute.CALENDER, "Calender", Icons.Outlined.DateRange, Icons.Default.DateRange),
                    Destination(MainNavGraphRoute.PROFILE, "Profile", Icons.Outlined.Person, Icons.Default.Person)
                )
            )
        }
    ){ paddingValues ->
        MenuBarNavHost(
            navController = navController,
        )
    }
}
