package com.gogleset.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gogleset.app.ui.theme.AppTheme

@Composable
fun SecondScreen(age:Int, name: String, navigateToHome:()-> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Second Screen")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "안녕하세요 ${age}살인 ${name}님!")
        Button(onClick = { navigateToHome() }) {
            Text(text = "Return Home")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    AppTheme {
        SecondScreen(24, "Alex") {}
    }
}