package com.example.instagram.presentation.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    object Search : BottomNavItem("search", Icons.Default.Search, "Search")
    object Reels : BottomNavItem("reels", Icons.Default.PlayArrow, "Reels")
    object Notifications : BottomNavItem("notifications", Icons.Default.Notifications, "Notifications")
    object Profile : BottomNavItem("profile", Icons.Default.Person, "Profile")
}
