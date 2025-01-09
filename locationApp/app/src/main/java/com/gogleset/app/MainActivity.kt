package com.gogleset.app

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import com.gogleset.app.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: LocationViewModel by viewModels()
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier = Modifier.padding(innerPadding), viewModel)
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier, viewmodel: LocationViewModel) {
//    지금 내가 있는 액티비티의 context를 달라는 것
    val context = LocalContext.current
    val locationUtils = LocationUtils(context)

    LocationDisplay(modifier, locationUtils = locationUtils, context = context, viewmodel)
}


@Composable
fun LocationDisplay(
    modifier: Modifier,
    locationUtils: LocationUtils,
    context: Context,
    viewModel: LocationViewModel
) {
    val location = viewModel.location.value

    val address = location?.let {
        locationUtils.reverseGeocodeLocation(location)
    }
//    결과를 위해 액티비티를 시작하라는 요청을 등록
//    자동으로 관리 요청 코드 및 레코드 생성
//    팝업 내부에 내용이 반환되면 결과 알려줘
    val requestPermissionLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
//          권한이 있는지 체크
            if (permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true && permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true) {


                Toast.makeText(context, "Location Permissions Granted!", Toast.LENGTH_SHORT).show()
                //              위치 관련  권한이 없다면
            } else {
                // 하나 이상의 권한이 거부된 경우
                val rationaleRequired = ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) || ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )

                if (rationaleRequired) {
                    Toast.makeText(
                        context,
                        "Location Permission is required for this feature to work",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context,
                        "Location Permission is required. Please enable it in Android Settings",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (location != null) {
            Text(text = "Address ${location.latitude} ${location.longitude} \n $address")
        } else {
            Text(text = "Location not available")
        }
        Button(onClick = {
            if (locationUtils.hasLocationPermission(context)) {
//            만약 권한이 승인됐다면 위치를 업데이트
                locationUtils.requestLocationUpdates(viewModel)
            } else {
//             위치 권한 요청
                requestPermissionLauncher.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
        }) {
            Text(text = "Get Location")
        }
    }
}