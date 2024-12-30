package com.gogleset.kotlinbasics

//프로그램의 시작점, index.html이라 생각
fun main() {
//    call function
    makeCoffee(sugarCount = 1, name = "Jin")
    makeCoffee(0, "Jimmy")
    makeCoffee(-2, "John")
}


fun makeCoffee(sugarCount: Int, name: String) {
    if (sugarCount == 0) {
        println("Coffee with no sugar for $name")
    } else if (sugarCount == 1) {
        println("Coffee with $sugarCount spoon of sugar for $name")
    } else {
        println("Coffee with $sugarCount spoons of sugar for $name")
    }
}