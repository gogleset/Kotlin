package com.gogleset.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _categorieState = mutableStateOf(RecipeState())
    val categoriesState: MutableState<RecipeState> = _categorieState

    init{
        fetchCategories()
    }
//    fetchCategory
    private fun fetchCategories() {
//        coroutine 실행(백그라운드 루틴실행)
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                categoriesState.value = _categorieState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )

            } catch (e: Exception) {
                _categorieState.value = categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val loading: Boolean = true , //로딩상태
        val list: List<Category> = emptyList(), //실질적 아이템
        val error: String? = null //error 여부
    )

}