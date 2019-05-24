package codeforces.coverpoints

import kotlin.math.max

fun minLengthCoverPoints(): Int {
    val n = readLine()!!.toInt()
    var count = 0
    var s = readLine()!!.split(" ")
    var maxPointRange = 0

    do {
        maxPointRange = max(maxPointRange, (s[0].toInt() + s[1].toInt()))
        if (count + 1 == n) {
            break
        }
        s = readLine()!!.split(" ")
        count++

    } while (true)

    return maxPointRange
}

fun main(args: Array<String>) {
    println(minLengthCoverPoints())
}