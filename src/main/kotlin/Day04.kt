import java.io.File

fun main(args: Array<String>) {
    val lines = File("src/main/resources/day04.txt").bufferedReader().readLines()

    var resultA = 0
    var resultB = 0

    for(line in lines) {
        var ranges = line.split(",")
        val range1 = parseRange(ranges[0])
        val range2 = parseRange(ranges[1])
        if (range1.containsAll(range2) || range2.containsAll(range1)) {
            resultA++
        }

        var combined = HashSet<Int>()
        combined.addAll(range1)
        combined.addAll(range2)

        if (combined.size != range1.size + range2.size) {
            resultB++
        }
    }
    println("Day 4a")
    println(resultA)
    println("Day 4b")
    println(resultB)

}

fun parseRange(input: String): ArrayList<Int> {
    val inputParts = input.split("-").map { it.toInt() }
    val result = ArrayList<Int>()

    for(i in IntRange(inputParts[0], inputParts[1])) {
        result.add(i)
    }

    return result;
}