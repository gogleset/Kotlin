package com.gogleset.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogleset.unitconverter.ui.theme.UnitConverterTheme

import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UnitConverter(innerPadding)
                }
            }
        }
    }
}


@Composable
fun UnitConverter(paddingValues: PaddingValues) {
    val customTextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp,
        color = Color.Red
    )

    var inputValue by remember {
        mutableStateOf(
            ""
        )
    }
    var outputValue by remember {
        mutableStateOf("")
    }
    var inputUnit by remember {
        mutableStateOf("Centimeters")
    }
    var outputUnit by remember {
        mutableStateOf("Centimeters")
    }
    var iExpanded by remember {
        mutableStateOf(false)
    }
    var oExpended by remember {
        mutableStateOf(false)
    }
    val conversionFactor = remember {
        mutableDoubleStateOf(1.00)
    }
    val oConversionFactor = remember {
        mutableDoubleStateOf(1.00)
    }


    fun convertUnits(){
//    ?:   elvis operator
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0).roundToInt() / 100.0
        outputValue = result.toString()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
//            .background(Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        UI 요소가 세로로 하나씩 쌓일 것이다.
        Text("Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
//        Input Text같은 것
        OutlinedTextField(value = inputValue, onValueChange = {
//            익명함수
            inputValue = it // 람다 함수에 매개변수가 하나만 있을 경우,  it 으로 참조함
        }, label = {
            Text("Enter Value")
        })
        Spacer(modifier = Modifier.height(16.dp))
        Row() {
//        UI 요소가 가로로 하나씩 쌓일 것이다.
//            val context = LocalContext.current
//            Button(onClick = {
////                토스트 메세지 표시
//                Toast.makeText(context, "Thanks for Clicking", Toast.LENGTH_LONG).show()
//            }) {
//                Text(text = "Click")
//            }

//          input box
            Box() {
                var context = LocalContext.current
                Button(onClick = { iExpanded = true }) {
                    Text(text = inputUnit)
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "DropDown")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(text = {
                        Text(text = "Centimeters")
                    }, onClick = {
                        iExpanded = false
                        inputUnit = "Centimeters"
                        conversionFactor.value = 0.01
                        convertUnits()
                    }
                    )
                    DropdownMenuItem(text = {
                        Text(text = "Meters")
                    }, onClick = { iExpanded = false
                        inputUnit = "Meters"
                        conversionFactor.value = 1.0
                        convertUnits()
                    }
                    )
                    DropdownMenuItem(text = {
                        Text(text = "Milimeters")
                    }, onClick = { iExpanded = false
                        inputUnit = "Milimeters"
                        conversionFactor.value = 0.001
                        convertUnits()
                    }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
//            outputBox
            Box {
                Button(onClick = { oExpended = true }) {
                    Text(text = outputUnit)
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "DropDown")
                }
                DropdownMenu(expanded = oExpended, onDismissRequest = { oExpended = false }) {
                    DropdownMenuItem(text = {
                        Text(text = "Centimeters")
                    }, onClick = { oExpended = false
                        outputUnit = "Centimeters"
                        oConversionFactor.value = 0.01
                        convertUnits() }
                    )
                    DropdownMenuItem(text = {
                        Text(text = "Meters")
                    }, onClick = {oExpended = false
                        outputUnit = "Meters"
                        oConversionFactor.value = 1.0
                        convertUnits()}
                    )
                    DropdownMenuItem(text = {
                        Text(text = "Milimeters")
                    }, onClick = { oExpended = false
                        outputUnit = "Milimeters"
                        oConversionFactor.value = 0.001
                        convertUnits()}
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "Result: $outputValue $outputUnit ", style = customTextStyle)
    }
}


@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            UnitConverter(innerPadding)
        }
    }
}