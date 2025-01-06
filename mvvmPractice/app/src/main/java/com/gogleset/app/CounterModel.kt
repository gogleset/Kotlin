package com.gogleset.app

data class Counter(var count: Int)

class CounterRepository {
    private val _counter = Counter(0)

    fun getCounter() = _counter

    fun increment(){
        _counter.count++
    }

    fun decrement(){
        _counter.count--
    }

}