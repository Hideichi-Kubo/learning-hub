package com.example.unsplashclient.presentation

sealed class ScreenRoute(val route: String) {
    object SearchScreen : ScreenRoute(route = "search_photos_screen")
    object PhotoDetailScreen : ScreenRoute(route = "photo_detail_screen")
}