package com.gogleset.shoppingapp

import retrofit2.http.GET
import retrofit2.http.Query


interface GeocodingApiService {


    @GET("maps/api/geocode/json")
    suspend fun getAddressFromCoordinate(
        @Query("latlng") latlng: String,
        @Query("key") apiKey: String
    ): GeocodingResponse
}