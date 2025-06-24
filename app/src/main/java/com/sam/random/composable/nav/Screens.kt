package com.sam.random.composable.nav

sealed class Screens(val screenName: String) {
    data object Home : Screens("home")
    data object Profile : Screens("profile")
    data object Settings : Screens("settings")
}