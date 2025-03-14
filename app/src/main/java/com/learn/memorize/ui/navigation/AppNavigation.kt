package com.learn.memorize.ui.navigation

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.learn.memorize.ui.screens.authentication.ForgetPasswordScreen
import com.learn.memorize.ui.screens.authentication.SignInScreen
import com.learn.memorize.ui.screens.authentication.SignUpScreen
import com.learn.memorize.ui.screens.main.ArchiveScreen
import com.learn.memorize.ui.screens.main.DiscoveryScreen
import com.learn.memorize.ui.screens.main.HomeScreen
import com.learn.memorize.ui.screens.main.ProfileScreen

@Composable
fun AppNavigation(modifier: Modifier, windowSize: WindowWidthSizeClass){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main"){
        // Authentication Navigation Graph
        navigation(route = "authentication", startDestination = "signin"){
            composable(route = "signin") {
                    SignInScreen(navController, windowSize = windowSize)
            }
            composable(route = "signup") {
                SignUpScreen(navController, windowSize = windowSize)
            }
            composable(route = "forgetpassword") {
                ForgetPasswordScreen(navController, windowSize = windowSize)
            }
        }
        // Main Pages Navigation Graph
        navigation(route = "main", startDestination = "home"){
            composable(route = "home") {
                HomeNavigation(navController = navController, windowSize=windowSize)
            }
            composable(route="archive") {
                ArchiveScreen(windowSize = windowSize, modifier = modifier)
            }
            composable(route = "discovery") {
                DiscoveryScreen(modifier = modifier)
            }
            composable(route = "profile") {
                ProfileScreen()
            }
        }
        // details Pages Navigation Graph

    }
}