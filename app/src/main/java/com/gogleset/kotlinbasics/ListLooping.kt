package com.gogleset.kotlinbasics

fun main() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)

    for (index in 0..<numbers.size) {
        println("numbers item ${numbers[index]} index ::: $index")
        numbers[index] = numbers[index] * 2
    }

    println(numbers)
}