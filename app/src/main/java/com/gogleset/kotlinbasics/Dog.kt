package com.gogleset.kotlinbasics

class Dog(
    val name: String,
    val breed: String,
    var age: Int = 0
) { // val, var 이라는 키워드를 쓴다면 Dog.breed처럼 프로퍼티로 접근할 수 있다. 없다면 파라미터로 동작한다.
    //    객체를 생성하는 순간 실행할 로직
    init {
        bark(name)
    }

    private fun bark(name: String) {
        println("$name says Woof Woof")
    }
}