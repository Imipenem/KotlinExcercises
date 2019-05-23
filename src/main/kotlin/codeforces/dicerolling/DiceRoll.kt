package codeforces.dicerolling

fun roll(n: Int) = if (n % 2 == 0) n / 2 else ((n - 2) / 2) + 1

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()

    for (i in 0 until t) {
        println(roll(readLine()!!.toInt()))
    }
}