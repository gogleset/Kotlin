package com.gogleset.wishlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.gogleset.wishlistapp.ui.theme.WishListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel = WishViewModel()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WishListAppTheme {
                Navigation(viewModel = viewModel)
            }
        }
    }
}