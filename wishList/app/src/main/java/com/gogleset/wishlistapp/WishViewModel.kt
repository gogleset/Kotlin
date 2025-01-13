package com.gogleset.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gogleset.wishlistapp.data.Wish
import com.gogleset.wishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(private val wishRepository: WishRepository) : ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newString: String) {
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString: String) {
        wishDescriptionState = newString
    }

    var myInt = 5

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWishes()
        }
    }

    fun addWish(wish: Wish) {
//        dispatcher.io 블로킹 작업(예: 파일 읽기/쓰기, 네트워크 호출) 중에도 다른 코루틴 작업이 스레드를 사용할 수 있도록 관리.
//        코루틴 디스패처 중 하나로, 입출력(IO) 작업에 최적화된 디스패처입니다. 주로 파일 읽기/쓰기, 네트워크 요청, 데이터베이스 작업과 같은 입출력 중심의 작업을 처리
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addAWish(wish)
        }
    }

    fun getAWishByID(id: Long): Flow<Wish> {
        return wishRepository.getAWishById(id)
    }

    fun updateWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateAWish(wish)
        }
    }

    fun deleteWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteAWish(wish)
        }
    }

}