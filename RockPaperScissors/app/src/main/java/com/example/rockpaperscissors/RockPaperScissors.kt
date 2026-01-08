package com.example.rockpaperscissors

fun main() {
    while (true) {
        val playerChoice = readChoice()
        if (playerChoice == "exit") break

        println("You chose $playerChoice")

        val randomNumber = (1..3).random()

        val computerChoice =
            when (randomNumber) {
                1 -> "rock"
                2 -> "paper"
                3 -> "scissors"
                else -> "error"
            }
        println("Computer chose $computerChoice")

        // 勝者判定
        val winner =
            when {
                playerChoice == computerChoice -> "Draw"
                playerChoice == "rock" && computerChoice == "scissors" -> "Player"
                playerChoice == "paper" && computerChoice == "rock" -> "Player"
                playerChoice == "scissors" && computerChoice == "paper" -> "Player"
                else -> "Computer"
            }

        // 結果発表
        if (winner == "Draw") println("It's a draw!") else println("$winner wins!")
        println()
    }
}

fun readChoice(): String {
    val inValid = setOf("rock", "paper", "scissors, exit")
    while (true) {
        println("Enter your choice: rock, paper, or scissors (or exit to quit)")
        val input = readln().trim().lowercase()
        if (input in inValid) return input
        println("Invalid choice. Please try again.")
    }
}
