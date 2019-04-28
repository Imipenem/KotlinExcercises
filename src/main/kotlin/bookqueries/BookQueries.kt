
import kotlin.math.min

fun printQueries() {
    val t = readLine()!!.toInt()
    val n = 200000+11
    val positions = IntArray(n)
    var curr = 0 // this indicates the current rightmost pos
    var curl = 0 // this indicates the current leftmost pos
    var count = 0

    while (count < t) {
        val query = readLine()!!.split(" ")
        val id = query[1].toInt()

        if (count == 0) {
            positions[id] = curl
            --curl
            ++curr
        }

        else {
            when (query[0]) {
                "L" -> {
                    positions[id] = curl
                    --curl
                }
                "R" -> {
                    positions[id] = curr
                    ++curr
                }
                "?" -> println("${Math.min(Math.abs(positions[id] - curl), Math.abs(positions[id] - curr)) - 1}")
            }
        }
        count++
    }
}

fun main(args: Array<String>) {
    printQueries()
}