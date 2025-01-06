package com.gogleset.app

import com.gogleset.app.MovieResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val key = "d145fd2512b2f9be50d440aedfa4b898"

//https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=d145fd2512b2f9be50d440aedfa4b898&targetDt=20120101
private val retrofit = Retrofit.Builder().baseUrl("https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/")
    .addConverterFactory(GsonConverterFactory.create()).build()

val movieService: ApiService = retrofit.create(ApiService::class.java)
interface ApiService {

    @GET("searchDailyBoxOfficeList.json")
    suspend fun getMovie(
        @Query("key") apiKey: String = key, // API 키 기본값 설정
        @Query("targetDt") targetDate: String // 날짜를 파라미터로 받음
    ): MovieResult
}