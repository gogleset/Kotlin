package com.gogleset.meals

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gogleset.meals.screen.CategoryDetailScreen
import com.gogleset.meals.screen.RecipeScreen

@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(modifier = Modifier.padding(10.dp), viewState) {
//              상태(State) 관리와 URL 경로에 기반한 데이터 전달을 결합한 형태
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
//              이동
                navController.navigate(Screen.DetailScreen.route)
            }
        }
        composable(route = Screen.DetailScreen.route) {
//           savedStateHandle에 저장된 state를 가져옴
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")
                    ?: Category("", "", "", "")
            CategoryDetailScreen(category)
        }
    }
}