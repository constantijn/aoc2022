import java.io.File
import java.util.Stack

fun main(args: Array<String>) {
    println("Day 5a")
    val lines = File("src/main/resources/day05.txt").bufferedReader().readLines()

    val stackLines = ArrayList<String>()
    val moveLines = ArrayList<String>()
    var endOfStackLines = false

    for(line in lines) {
        if (line.isEmpty()) {
            endOfStackLines = true
            continue
        } else if (!endOfStackLines) {
            stackLines.add(line)
        } else {
            moveLines.add(line)
        }
    }

    stackLines.reverse()
    val stackCount = stackLines.removeAt(0).trim().replace("   ", " ").split(" ").last().toInt()
    val stacks = ArrayList<Stack<Char>>()

    for(i in 0 .. stackCount) {
        stacks.add(Stack())
    }

    for(line in stackLines) {
        for (stackIndex in 1.. stackCount) {
            val stringIndex = stackIndex * 4 - 3
            if (line.length > stringIndex) {
                if (line[stringIndex].isLetter()) {
                    stacks[stackIndex].add(line[stringIndex])
                }
            }
        }
    }

    for(line in moveLines) {
        val moveParts = line.split(" ")
        val count = moveParts[1].toInt()
        val from = moveParts[3].toInt()
        val to = moveParts[5].toInt()

        // part a
//        for (i in 1..count) {
//            stacks[to].add(stacks[from].pop())
//        }

        // part b
        val temp = Stack<Char>()
        for (i in 1..count) {
            temp.add(stacks[from].pop())
        }
        for (i in 1..count) {
            stacks[to].add(temp.pop())
        }
    }

    for(i in 1..stackCount) {
        print(stacks[i].peek())
    }
    println()

}
