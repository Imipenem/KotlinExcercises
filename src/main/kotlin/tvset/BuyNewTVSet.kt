package tvset

import kotlin.math.min

fun buyTvSet(a: Long, b: Long, x: Long, y: Long) = min(a / (x / gcd(x, y)), b / (y / gcd(x, y)))

fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) {
        a
    } else {
        gcd(b, a % b)
    }
}

fun main(args: Array<String>) {
    val s =readLine()?.let { line ->
        line.split(" ").map {
            it.toLong()
        }
    }
    println(buyTvSet(s!![0], s[1], s[2], s[3]))
}