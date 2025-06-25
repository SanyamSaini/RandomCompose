package com.sam.random.composable.bottomnav

sealed class BottomScreens(val screenName: String) {
    data object Home: BottomScreens("home")
    data object Profile: BottomScreens("profile")
    data object Search: BottomScreens("search")
    data object Notification: BottomScreens("notification")
    data object Post: BottomScreens("post")
}