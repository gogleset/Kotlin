package com.gogleset.kotlinbasics

//모두 val이나 var사용 데이터를 저장하기 위한 class
data class CoffeeDetails(
    val sugarCount: Int,
    val name: String,
    val size: String,
    val creamAmount: Int
)

//프로그램의 시작점, index.html이라 생각
fun main() {
//    call function
    val coffeeForDenis = CoffeeDetails(2, "denis", "xxl", 0)
    makeCoffee(coffeeForDenis)
}


fun divide(num1: Double, num2: Double): Double {
    return (num1 / num2).toDouble()
}

fun add(num1: Int, num2: Int): Int {
    return num1 + num2
}


fun askCoffeeDetails() {
    //    call function
    println("Who is coffee for?")
    val name = readln()
    println("How many pieces of sugar do u want?")
    val sugarCount = readln().toInt()
//    makeCoffee(sugarCount, name)
}

//fun makeCoffee(sugarCount: Int, name: String) {
//    if (sugarCount == 0) {
//        println("Coffee with no sugar for $name")
//    } else if (sugarCount == 1) {
//        println("Coffee with $sugarCount spoon of sugar for $name")
//    } else {
//        println("Coffee with $sugarCount spoons of sugar for $name")
//    }
//}


fun makeCoffee(coffeeDetails: CoffeeDetails) {
    if (coffeeDetails.sugarCount == 0) {
        println("Coffee with no sugar for ${coffeeDetails.name} and size: ${coffeeDetails.size}")
    } else if (coffeeDetails.sugarCount == 1) {
        println(
            "Coffee with ${coffeeDetails.sugarCount} spoon of sugar for ${coffeeDetails.name}, " +
                    "and cream: ${coffeeDetails.creamAmount} and size: ${coffeeDetails.size}"
        )
    } else {
        println(
            "Coffee with ${coffeeDetails.sugarCount} spoons of sugar for ${coffeeDetails.name} " +
                    "and cream: ${coffeeDetails.creamAmount} and size: ${coffeeDetails.size}"
        )
    }
}