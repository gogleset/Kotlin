package com.gogleset.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.gogleset.myapplication.ui.theme.MyApplicationTheme
import com.gogleset.myapplication.view.LocationScreen
import com.gogleset.myapplication.viewModel.LocationViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: LocationViewModel by viewModels()
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(
                        modifier = Modifier.padding(innerPadding), viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier, viewModel: LocationViewModel) {
    val context = LocalContext.current
    LocationScreen(modifier, context = context, viewModel)
}

