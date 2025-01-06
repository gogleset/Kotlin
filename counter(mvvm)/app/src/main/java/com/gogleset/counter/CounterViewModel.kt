package com.gogleset.counter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel() {
    // CounterRepository를 통해 데이터를 관리합니다.
    private val _repository: CounterRepository = CounterRepository()

    // mutableIntStateOf로 상태 값을 관리하며, 초기값은 Repository에서 가져옵니다.
    private var _count = mutableIntStateOf(_repository.getCounter().count)

    // 외부에서 읽기만 가능한 상태 값입니다.
    val count: MutableState<Int> = _count

    fun increment() {
        // Repository에서 카운터 값을 증가시킵니다.
        _repository.incrementCounter()
        // Repository의 변경된 값을 mutableIntState에 반영하여 UI에 업데이트합니다.
        _count.intValue = _repository.getCounter().count
    }

    fun decrement() {
        // Repository에서 카운터 값을 감소시킵니다.
        _repository.decrementCounter()
        // 변경된 값을 mutableIntState에 반영하여 UI에 업데이트합니다.
        _count.intValue = _repository.getCounter().count
    }
}
