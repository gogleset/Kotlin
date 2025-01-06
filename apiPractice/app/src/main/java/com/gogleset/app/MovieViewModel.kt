package com.gogleset.app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar

class MovieViewModel : ViewModel() {
    //    ViewModel에서 private하게 상태관리할 mutableState 만들기
    private val _movieState = mutableStateOf(MovieState())

    //    View에서 접근할 copy state만들어서 접근권한 주기
    var movieState: MutableState<MovieState> = _movieState

    init{
        fetchMovies(date = null)
    }


    private fun fetchMovies(date: String?) {
        //        coroutine 실행(백그라운드 루틴실행)
        viewModelScope.launch {
            try {
                var calendar = Calendar.getInstance()
                calendar.add(Calendar.DAY_OF_YEAR, -1) //변경하고 싶은 원하는 날짜 수를 넣어 준다.
                var timeToDate = calendar.time
                var formatter = SimpleDateFormat("yyyyMMdd") //날짜의 모양을 원하는 대로 변경 해 준다.
                //formatter.timeZone = TimeZone.getTimeZone("Asia/Seoul")
                var finalResultDate = date ?: formatter.format(timeToDate)
                println(finalResultDate)
//                API Service에게 get 요청하기
                val response = movieService.getMovie(targetDate = finalResultDate)
                println("relay response")
                println(response)
//                접근 가능한 state에게 값 업데이트
                movieState.value = _movieState.value.copy(loading = false, result = response, error = null)
            } catch (e: Exception) {
                println("Error Message")
                println(e.message)
                //                접근 가능한 state에게 값 업데이트
                movieState.value = _movieState.value.copy(loading = false, result = null, error = "${e.message}")
            }
        }
    }


    //    View에 그려질 상태
    data class MovieState(
        val loading: Boolean = true, //로딩상태
        val result: MovieResult? = null, //실질적 아이템
        val error: String? = null //error 여부
    )
}