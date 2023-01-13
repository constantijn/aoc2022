import java.io.File

fun main(args: Array<String>) {
    println("Day 3a")
    val lines = File("src/main/resources/day03.txt").bufferedReader().readLines()
    var result = 0

    for(line in lines) {
        var len = line.length / 2
        var part1 = HashSet(line.substring(0, len).toCharArray().toSet())
        var part2 = HashSet(line.substring(len).toSet())
        part1.retainAll(part2)
        var duplicate = part1.iterator().next()
        result += priority(duplicate)
    }
    println(result)

    result = 0
    println("Day 3b")

    for (i in lines.indices step 3) {
        var line1 = HashSet(lines.get(i).toCharArray().toSet())
        var line2 = HashSet(lines.get(i + 1).toCharArray().toSet())
        var line3 = HashSet(lines.get(i + 2).toCharArray().toSet())

        line1.retainAll(line2)
        line1.retainAll(line3)

        result += priority(line1.iterator().next())
    }
    println(result)

}

fun priority(input: Char): Int {
    if (input.isLowerCase()) {
        return input.code - 96
    }
    return input.code - 38
}