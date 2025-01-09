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
fun FirstScreen(navigateToFriends: (age: Int, name:String) -> Unit) {
    val inputAgeValue = remember {
        mutableIntStateOf(0)
    }

    val inputNameValue = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "First Screen")
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = inputAgeValue.intValue.toString(), onValueChange = {
            inputAgeValue.intValue = it.toInt()
        })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = inputNameValue.value, onValueChange = {
            inputNameValue.value = it
        })
        Button(onClick = {navigateToFriends(inputAgeValue.intValue, inputNameValue.value) }) {
            Text(text = "Toss! age ${inputAgeValue.intValue} name ${inputNameValue.value}")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    AppTheme {
        FirstScreen { age, _ -> println(age) }
    }
}