package com.gogleset.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gogleset.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), content = { innerPadding ->
                    CaptainGame(innerPadding)
                })
            }
        }
    }
}


@Composable
fun CaptainGame(innerPaddingValues: PaddingValues) {
//    가변상태의 값을 저장하는 상수(useState)
//    val treasuresFound = remember {
//        mutableIntStateOf(0)
//    }
    var treasuresFound by remember { // by 키워드를 사용하게 되면 바로 State를 사용가능하게 한다. .을 쓸 필요가 없다.
        mutableIntStateOf(0)
    }
    val direction = remember {
        mutableStateOf("North")
    }
    val stormOrTreasure = remember {
        mutableStateOf("")
    }

    fun captainButtonOnClick(directionValue: String) {
        direction.value = directionValue
        if (Random.nextBoolean()) {
            treasuresFound += 1
            stormOrTreasure.value = "Found a Treasure!"
        } else {
            stormOrTreasure.value = "Storm Ahead!"
        }
    }

//  View
    Column(
        modifier = Modifier
            .fillMaxSize() // 전체 화면 채우기
            .padding(innerPaddingValues)
    ) {
        Text("Treasures Found: $treasuresFound")
        Text("Current Direction: ${direction.value}")
        Text(text = stormOrTreasure.value)
//        Text("Treasures Found: ${treasuresFound.intValue}")
//        Text("Current Direction: ${direction.value}")
//        Button(onClick = {
//            direction.value ="East"
//            if(Random.nextBoolean()){
//                treasuresFound.intValue += 1
//            }
//        }) {
//            Text("Sail East")
//        }
        CaptainButton("East", onClick = { captainButtonOnClick("East") })
        CaptainButton("North", onClick = { captainButtonOnClick("North") })
        CaptainButton("West", onClick = { captainButtonOnClick("West") })
        CaptainButton("South", onClick = { captainButtonOnClick("South") })

    }
}


@Composable
fun CaptainButton(direction: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Sail $direction")
    }
}


@Preview
@Composable
fun CaptainGamePreview() {
    CaptainGameTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), content = { innerPadding ->
            CaptainGame(innerPadding)
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
        })
    }
}
