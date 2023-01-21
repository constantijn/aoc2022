import java.io.File

data class FsEntry(val isDir: Boolean, val name: String, val size:Int?)

fun main(args: Array<String>) {
    val lines = File("src/main/resources/day07.txt").bufferedReader().readLines()
    val path = ArrayList<String>()
    val directories = HashMap<String, ArrayList<FsEntry>>()
    directories["/"] = ArrayList()

    for(line in lines) {
        if (line[0] == '$') {
            val commandParts = line.split(" ")
            if ("cd" == commandParts[1] && "/" == commandParts[2]) {
                path.clear()
            } else if ("cd" == commandParts[1] && ".." == commandParts[2]) {
                path.removeLast();
            }else if ("cd" == commandParts[1]) {
                path.add(commandParts[2])
                directories.putIfAbsent("/" + path.joinToString("/"), ArrayList())
            } else if ("ls" == commandParts[1]) {
                // handled below in else
            } else {
                throw RuntimeException("Unknown command [${commandParts[1]}]")
            }
        } else { // ls output
            val pathString = "/" + path.joinToString("/")
            val lsParts = line.split(" ")
            if ("dir" == lsParts[0]) {
                directories[pathString]?.add(FsEntry(true, lsParts[1], null))
            } else {
                directories[pathString]?.add(FsEntry(false, lsParts[1], lsParts[0].toInt()))
            }
        }
    }

    var extraSpaceNeeded = 30000000 - (70000000 - dirSize("/", directories))

    var resultA = 0
    var resultB = Int.MAX_VALUE
    for(entry in directories.entries) {
        var size =  dirSize(entry.key, directories)
        if (size <= 100000) {
            resultA += size
        }
        if (size >= extraSpaceNeeded) {
            resultB = size.coerceAtMost(resultB) // Kotlin version of Math.min
        }
    }
    println("Day 7a")
    println(resultA)
    println("Day 7b")
    println(resultB)
}

fun dirSize(path: String, directories: HashMap<String, ArrayList<FsEntry>>): Int {
    var result = 0
    for(fsEntry in directories[path]!!) {
        result += if (fsEntry.isDir) {
            dirSize("$path/${fsEntry.name}".replaceFirst("//", "/"), directories)
        } else {
            fsEntry.size!!
        }
    }
    return result
}
