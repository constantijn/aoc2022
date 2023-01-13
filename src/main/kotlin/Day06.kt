import java.io.File
import java.util.Stack

fun main(args: Array<String>) {
    println("Day 6a")
    val data = File("src/main/resources/day06.txt").bufferedReader().readLines().first()

    for (i in 4 until data.length) {
        val window = data.substring(i-4,i)
        val uniques = window.toCharArray().toSet()
        if (uniques.size == 4) {
            println(i)
            break
        }
    }

    println("Day 6b")
    for (i in 14 until data.length) {
        val window = data.substring(i-14,i)
        val uniques = window.toCharArray().toSet()
        if (uniques.size == 14) {
            println(i)
            break
        }
    }


}
