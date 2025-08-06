//package com.vobot.rentals.component
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.navigationBarsPadding
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.BottomAppBar
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableIntStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.drawBehind
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//
//@Composable
//fun RentalsBottomAppBar(
//    modifier: Modifier = Modifier,
//    navController : NavController
//) {
//    val startDestination = Destination.HOME
//    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }
//
//    val interactionSource = remember { MutableInteractionSource() }
//    val outlineVariant = MaterialTheme.colorScheme.outlineVariant
//
//    BottomAppBar(
//        modifier = modifier
//            .navigationBarsPadding()
//            .height(60.dp)
//            .fillMaxWidth()
//            .drawBehind {
//                val strokeWidth = 1.dp.toPx()
//                drawLine(
//                    color = outlineVariant,
//                    start = Offset(0f, 0f),
//                    end = Offset(size.width, 0f),
//                    strokeWidth = strokeWidth
//                )
//            },
//        contentPadding = PaddingValues(0.dp),
//        containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
//        contentColor = MaterialTheme.colorScheme.onSurface,
//        tonalElevation = 10.dp,
//    ) {
//        Box(
//            modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight()
//                    .padding(horizontal = 25.dp)
//                    .padding(top = 5.dp),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.Top
//            ) {
//                Destination.entries.forEachIndexed { index, destination ->
//                    Column(
//                        Modifier.clickable(
//                            indication = null, interactionSource = interactionSource
//                        ) {
//                            navController.navigate(route = destination.route)
//                            selectedDestination = index
//                        },
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Icon(
//                            imageVector = if (selectedDestination == index) destination.filledIcon else destination.outlineIcon,
//                            contentDescription = null,
//                            tint = MaterialTheme.colorScheme.onSurface
//                        )
//
//                        Text(
//                            text = destination.label,
//                            style = MaterialTheme.typography.labelSmall,
//                            color = MaterialTheme.colorScheme.onSurface
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
