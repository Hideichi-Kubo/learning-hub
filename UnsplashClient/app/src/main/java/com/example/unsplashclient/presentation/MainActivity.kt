package com.example.unsplashclient.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unsplashclient.presentation.photo_detail.PhotoDetailScreen
import com.example.unsplashclient.presentation.search_photos.SearchPhotosScreen
import com.example.unsplashclient.presentation.ui.theme.UnsplashClientTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnsplashClientTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoute.SearchScreen.route,
                        modifier = Modifier.padding(innerPadding),
                    ) {
                        composable(route = ScreenRoute.SearchScreen.route) {
                            SearchPhotosScreen(navController)
                        }
                        composable(route = ScreenRoute.PhotoDetailScreen.route + "/{photoId}") {
                            PhotoDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
