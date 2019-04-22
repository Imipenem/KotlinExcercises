package vovaAndTrain

fun seeLaterns(L: Int, v: Int, l: Int, r: Int) = (L / v) - ((r / v) - (l - 1) / v)

fun noThree(n: Int) {
    when (n % 3) {
        0, 1 -> println("${1} ${1} ${n - 2}")
        2 -> println("${1} ${2} ${n - 3}")
    }
}

fun main(args: Array<String>) {
    noThree(readLine()!!.toInt())
}