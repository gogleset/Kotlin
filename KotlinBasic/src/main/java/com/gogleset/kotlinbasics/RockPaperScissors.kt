package com.gogleset.kotlinbasics

fun main() {
    var isNotValidInput = true
    while (isNotValidInput) {
        val playerChoice = readln().lowercase()
        val computerChoice = when ((1..3).random()) {
            1 -> {
                "Rock"
            }

            2 -> {
                "Paper"
            }

            else -> {
                "Scissors"
            }
        }.lowercase()
        if (playerChoice == "rock" || playerChoice == "paper" || playerChoice == "scissors") {
            isNotValidInput = false
            if (playerChoice == computerChoice) {
                println("Draw")
            } else if (playerChoice == "rock" && computerChoice == "scissors") {
                println("Win!")
            } else if (playerChoice == "scissors" && computerChoice == "paper") {
                println("Win!")
            } else if (playerChoice == "paper" && computerChoice == "rock") {
                println("Win!")
            } else {
                println("Lose!")
            }
        }

    }

}