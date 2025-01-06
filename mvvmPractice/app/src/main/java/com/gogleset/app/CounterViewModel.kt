package com.gogleset.app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel(){
    private val counterRepository = CounterRepository()
    val count = mutableIntStateOf(counterRepository.getCounter().count)

    fun incrementCount(){
        counterRepository.increment()
        count.intValue = counterRepository.getCounter().count
    }

    fun decrementCount(){
        counterRepository.decrement()
        count.intValue = counterRepository.getCounter().count
    }

}