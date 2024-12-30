package com.gogleset.kotlinbasics

fun main() {
    println("숫자를 입력해주세요: ")
    val inputString = readln()
    println(inputString)
    val inputNumber = inputString.toInt()
    println(inputNumber)
    val multiplier = 5

    println("연산결과는 : " + inputNumber * multiplier)
}