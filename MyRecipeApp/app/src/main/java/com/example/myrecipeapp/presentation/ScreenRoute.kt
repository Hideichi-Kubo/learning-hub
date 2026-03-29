package com.example.myrecipeapp.presentation

sealed class ScreenRoute(val route: String) {
    object RecipeScreen : ScreenRoute("recipe_screen")
    object CategoryDetailScreen : ScreenRoute("category_detail_screen")
}
