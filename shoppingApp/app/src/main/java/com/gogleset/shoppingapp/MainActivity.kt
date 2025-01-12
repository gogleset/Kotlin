package com.gogleset.shoppingapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.gogleset.shoppingapp.ui.theme.ShoppingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ShoppingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Navigation(innerPaddingValues = innerPadding)
                }
            }
        }
    }
}

@Composable
fun Navigation(innerPaddingValues: PaddingValues) {
    val navController = rememberNavController()
    val viewModel: LocationViewModel = viewModel()
    val context = LocalContext.current
    val locationUtils = LocationUtils(context)
    Log.d(
        "log",
        "viewmodel, ${viewModel.address.value},"
    )
    NavHost(navController = navController, startDestination = "shoppinglistscreen") {
//       전체화면
        composable("shoppinglistscreen") {
            ShoppingListApp(
                innerPaddingValues = innerPaddingValues,
                locationUtils = locationUtils,
                viewModel = viewModel,
                navController = navController,
                context = context,
                address = viewModel.address.value.firstOrNull()?.formatted_address ?: "No Address"
            )
        }
//         팝업
        dialog("locationscreen") { backstack ->
            viewModel.location.value?.let { it1 ->
                println(it1)
                LocationSelectionScreen(location = it1) { locationData ->
                    Log.d(
                        "log",
                        "locationData, ${locationData.latitude}, ${locationData.longitude}"
                    )

                    viewModel.fetchAddress(latlng = "${locationData.latitude},${locationData.longitude}")
                    navController.popBackStack()
                }
            }
        }
    }
}