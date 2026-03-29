package com.example.myrecipeapp.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipeapp.data.Category
import com.example.myrecipeapp.data.recipeApiService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _categoriesState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categoriesState

    init {
        fetchCategories()
    }

    fun fetchCategories() {
        viewModelScope.launch {
            try {
                val responce = recipeApiService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    isLoading = false,
                    categories = responce.categories,
                    error = null
                )

            } catch (e: Exception) {
                _categoriesState.value = _categoriesState.value.copy(
                    isLoading = false,
                    error = "Error fetching categories ${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val isLoading: Boolean = true,
        val categories: List<Category> = emptyList(),
        val error: String? = null
    )
}