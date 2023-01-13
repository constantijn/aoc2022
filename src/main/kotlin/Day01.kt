import java.io.File

fun main(args: Array<String>) {
    println("Day 1a")
    val lines = File("src/main/resources/day01.txt").bufferedReader().readLines()

    var counter = 0
    var result = ArrayList<Int>()

    for(line in lines) {
        if (line.isBlank()) {
            result.add(counter)
            counter = 0
        } else {
            counter += line.toInt()
        }
    }

    result.sort()
    result.reverse()
    println(result[0])

    println("Day 1b")
    println(result[0] + result[1] + result[2])

}