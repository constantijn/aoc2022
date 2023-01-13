import java.io.File

fun main(args: Array<String>) {
    println("Day 2a")
    val lines = File("src/main/resources/day02.txt").bufferedReader().readLines()

    var score = 0
    for(line in lines) {
        when(line) {
            "A X" -> score += 1 + 3 // rock -> rock
            "A Y" -> score += 2 + 6 // rock -> paper
            "A Z" -> score += 3 + 0 // rock -> scissors
            "B X" -> score += 1 + 0 // paper -> rock
            "B Y" -> score += 2 + 3 // paper -> paper
            "B Z" -> score += 3 + 6 // paper -> scissors
            "C X" -> score += 1 + 6 // scissors -> rock
            "C Y" -> score += 2 + 0 // scissors -> paper
            "C Z" -> score += 3 + 3 // scissors -> scissors
            else -> {
                println("line not matched [${line}]")
            }
        }
    }
    println(score)

    println("Day 2b")
    score = 0

    for(line in lines) {
        when(line) {
            // rock = 1, paper = 2, scissors = 3
            "A X" -> score += 3 + 0 // rock -> loose
            "A Y" -> score += 1 + 3 // rock -> draw
            "A Z" -> score += 2 + 6 // rock -> win
            "B X" -> score += 1 + 0 // paper -> loose
            "B Y" -> score += 2 + 3 // paper -> draw
            "B Z" -> score += 3 + 6 // paper -> win
            "C X" -> score += 2 + 0 // scissors -> loose
            "C Y" -> score += 3 + 3 // scissors -> draw
            "C Z" -> score += 1 + 6 // scissors -> win
            else -> {
                println("line not matched [${line}]")
            }
        }
        println("[$line] -> $score")
    }

    println(score)



}