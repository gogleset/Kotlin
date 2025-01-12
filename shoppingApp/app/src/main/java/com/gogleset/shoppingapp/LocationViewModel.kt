package com.gogleset.shoppingapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LocationViewModel : ViewModel() {
    private val _location = mutableStateOf<LocationData?>(null)
    val location: State<LocationData?> = _location

    private val _address = mutableStateOf(listOf<GeoCodingResult>())
    val address: State<List<GeoCodingResult>> = _address

    fun updateLocation(location: LocationData) {
        _location.value = location
    }

    fun fetchAddress(latlng: String) {

        try {
            viewModelScope.launch {
                val result = RetrofitClient.create().getAddressFromCoordinate(
                    latlng,
                    "AIzaSyB9_AhY_tl7Z4xgEGT2iBCxX0MXJbbVfQk"
                )
                Log.d(
                    "log",
                    "result, ${result.results}"
                )

                _address.value = result.results
            }
        } catch (e: Exception) {
            Log.d("res1", "${e.cause} ${e.message}")
        }
    }
}