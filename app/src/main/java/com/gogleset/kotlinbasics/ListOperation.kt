package com.gogleset.kotlinbasics

fun main() {
    val fruitsList = mutableListOf("APPLE", "BANANA", "ORANGE", "MELON", "PEANUT")
    fruitsList.add("MANGO")
    fruitsList.remove("PEANUT")
    println(fruitsList)

    if (fruitsList.contains("MANGO")) {
        println("Yeah Mango")
    } else {
        println("Eh~ Mango..")
    }
}