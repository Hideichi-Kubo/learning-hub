package com.example.myrecipeapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myrecipeapp.data.Category

@Composable
fun RecipeApp(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewModelState by recipeViewModel.categoriesState

    NavHost(
        navController = navController,
        startDestination = ScreenRoute.RecipeScreen.route,
        modifier = modifier
    ) {
        composable(ScreenRoute.RecipeScreen.route) {
            RecipeScreen(
                viewModelState = viewModelState,
                navigateToDetail = { category ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("category", category)
                    navController.navigate(route = ScreenRoute.CategoryDetailScreen.route)
                }
            )
        }
        composable(ScreenRoute.CategoryDetailScreen.route) {
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("category")
                ?: Category("", "", "", "")
            CategoryDetailScreen(
                category = category
            )
        }
    }
}