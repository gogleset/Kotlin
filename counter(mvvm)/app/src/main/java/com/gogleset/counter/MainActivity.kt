package com.gogleset.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogleset.counter.ui.theme.CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val viewModel: CounterViewModel by viewModels()
        setContent {
            CounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterApp(viewModel = viewModel, innerPaddingValues = innerPadding)
                }
            }
        }
    }
}

@Composable
fun CounterApp(innerPaddingValues: PaddingValues, viewModel: CounterViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues)
   , verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally ) {
        Text(text = "Count: ${viewModel.count.value}", style = TextStyle(
            fontSize = 32.sp,  // 큰 텍스트 크기
            fontWeight = FontWeight.Bold, // 굵은 텍스트
            color = Color.Black // 텍스트 색상
        ))
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {

            Button(onClick = {
                viewModel.increment()
            }) {
                Text(text = "Increment")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                viewModel.decrement()
            }) {
                Text(text = "Decrement")
            }
        }

    }

}

@Preview
@Composable
fun CounterAppPreview(){
    val counterViewModel = CounterViewModel()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        CounterApp(viewModel = counterViewModel, innerPaddingValues = innerPadding)
    }
}