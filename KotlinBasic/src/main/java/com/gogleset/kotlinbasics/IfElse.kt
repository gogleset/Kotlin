package com.gogleset.kotlinbasics

fun main() {
    println("Enter your age as a whole number: ")
    val age = readln().toInt()
//    if (age >= 40) {
//        println("You cannot go into the club, please go home.")
//    } else if (age >= 18) {
//        println("You can enter the club.")
//    } else {
//        println("Age not verified. Please contact support.")
//    }
//    if (age >= 18 && age < 41) {
//
//    }

    if (age in 18..40) {
        println()
    }
}