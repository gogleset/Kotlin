package com.gogleset.wishlistapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gogleset.wishlistapp.ui.theme.Screen

@Composable
fun Navigation(
    viewModel: WishViewModel,
    navController: NavHostController = rememberNavController()
) {

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeView(navController)
        }
        composable(Screen.AddScreen.route) {
            AddEditDetailView(id = 0, viewModel = viewModel, navController)
        }
    }

}