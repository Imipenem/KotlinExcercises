package codeforces.vovaAndTrain

fun seeLaterns(L: Int, v: Int, l: Int, r: Int) = (L / v) - ((r / v) - (l - 1) / v)

fun noThree(n: Int) {
    when (n % 3) {
        0, 1 -> println("${1} ${1} ${n - 2}")
        2 -> println("${1} ${2} ${n - 3}")
    }
}

fun minCoins(n: Int, S: Int) = if (S % n == 0) (S / n) else (S / n) + 1

fun main(args: Array<String>) {
    val s = readLine()!!.split(" ")
    println(minCoins(s[0].toInt(), s[1].toInt()))
}