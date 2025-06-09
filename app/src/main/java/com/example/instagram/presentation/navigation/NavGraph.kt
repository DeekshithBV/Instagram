package com.example.instagram.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instagram.presentation.home.HomeScreen
import com.example.instagram.presentation.upload.UploadScreen

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = "home", modifier = modifier) {

        composable("home") {
            HomeScreen()
        }

        composable("upload") {
            UploadScreen(onPostSuccess = {
                navController.navigate("home") {
                    popUpTo("upload") { inclusive = true }
                }
            })
        }

        composable("search") { /* TODO: SearchScreen() */ }
        composable("reels") { /* TODO: ReelsScreen() */ }
        composable("notifications") { /* TODO: NotificationsScreen() */ }
        composable("profile") { /* TODO: ProfileScreen() */ }
        // Add more screens: search, reels, etc.
    }
}
