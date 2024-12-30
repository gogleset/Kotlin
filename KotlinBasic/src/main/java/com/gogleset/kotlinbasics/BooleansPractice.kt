package com.gogleset.kotlinbasics

fun main() {
    var myTrue = true
    var myFalse = false

// OR 연산 || 두 boolean 중 하나라도 true이면 결과는 true가 됩니다.
    println(myTrue || myFalse)
// AND 연산에는 && 두 boolean 모두 true일 때에만 true가 됩니다.
    println(myTrue && myFalse)
// NOT 연산  불리언 값을 부정하기 위해 ! 기호를 사용
    println(!myTrue)
}