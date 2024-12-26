package com.gogleset.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gogleset.myfirstapp.ui.theme.MyFirstAppTheme

// MainActivity는 ComponentActivity처럼 동작해야하며 Activity는 화면에 보이는 것이라고 생각하면 된다.
class MainActivity : ComponentActivity() {
    // MainActivity 가 실행될때 실행될 함수
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Jin",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// composable => React 컴포넌트 개념
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

// 프로젝트 프리뷰, 애플리케이션에 변동사항 추가 및 실행 시 추가 시간 소요하는데, 미리보기 split view로 미리보기 할 수 있다.
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstAppTheme {
        Greeting("Denis")
    }
}