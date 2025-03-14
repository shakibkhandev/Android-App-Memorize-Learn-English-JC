package com.learn.memorize.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalLibrary
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.learn.memorize.ui.ViewModels.NavigationViewModel
import com.learn.memorize.ui.screens.main.ArchiveScreen
import com.learn.memorize.ui.screens.main.DiscoveryScreen
import com.learn.memorize.ui.screens.main.HomeScreen
import com.learn.memorize.ui.screens.main.ProfileScreen
import com.learn.memorize.ui.screens.main.bottomNavItemList

@Composable
fun HomeNavigation(
    navController: NavController,
    modifier: Modifier = Modifier,
    windowSize: WindowWidthSizeClass
) {
    val navigationViewModel: NavigationViewModel = viewModel()
    val selectedBottomIndex by navigationViewModel.selectedBottomIndex

    if (windowSize == WindowWidthSizeClass.Expanded) {
        // Expanded Mode: Use Row (NavigationRail + Content)
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Navigation Rail on the left
            BottomNavigationBar(
                navigationViewModel = navigationViewModel,
                selectedBottomIndex = selectedBottomIndex,
                windowSize = windowSize
            )

            // Content (Box will take the remaining space)
            Box(modifier = Modifier.weight(1f)) {
                HomeNavigationBottomTabsScreens(navController = navController, modifier = modifier, windowSize= windowSize)
            }
        }
    } else {
        // Compact Mode: Use Column (Content + Bottom Navigation)
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.weight(1f)) {
                HomeNavigationBottomTabsScreens(navController = navController, modifier = modifier, windowSize=windowSize)
            }
            BottomNavigationBar(
                navigationViewModel = navigationViewModel,
                selectedBottomIndex = selectedBottomIndex,
                windowSize = windowSize
            )
        }
    }
}


@Composable
fun HomeNavigationBottomTabsScreens(
    navController: NavController,
    modifier: Modifier = Modifier,
    navigationViewModel: NavigationViewModel = viewModel(),
    windowSize: WindowWidthSizeClass
) {
    val selectedBottomIndex by navigationViewModel.selectedBottomIndex

    when (selectedBottomIndex) {
        0 -> HomeScreen(modifier = modifier, windowSize = windowSize)
        1 -> ArchiveScreen(modifier=modifier, windowSize=windowSize)
        2 -> DiscoveryScreen(modifier = modifier)
        3 -> ProfileScreen()
        else -> HomeScreen(modifier = modifier, windowSize=windowSize)
    }
}


@Composable
fun BottomNavigationBar(
    navigationViewModel: NavigationViewModel = viewModel(),
    selectedBottomIndex: Int,
    windowSize: WindowWidthSizeClass
) {
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            // Bottom Navigation for Compact Screens (Phones)
            NavigationBar {
                bottomNavItemList.forEachIndexed { index, bottomNavItem ->
                    NavigationBarItem(
                        label = { Text(text = bottomNavItem.label) },
                        selected = index == selectedBottomIndex,
                        onClick = { navigationViewModel.setSelectedBottomIndex(index) },
                        icon = { Icon(imageVector = bottomNavItem.icon, contentDescription = bottomNavItem.label) }
                    )
                }
            }
        }

        WindowWidthSizeClass.Expanded -> {
            // Navigation Rail for Expanded Screens (Tablets, Large Devices)
            NavigationRail(modifier = Modifier.fillMaxHeight()) {
                bottomNavItemList.forEachIndexed { index, bottomNavItem ->
                    NavigationRailItem(
                        label = { Text(text = bottomNavItem.label) },
                        selected = index == selectedBottomIndex,
                        onClick = { navigationViewModel.setSelectedBottomIndex(index) },
                        icon = { Icon(imageVector = bottomNavItem.icon, contentDescription = bottomNavItem.label) }
                    )
                }
            }
        }
    }
}
