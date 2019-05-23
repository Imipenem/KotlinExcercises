package codeforces.primediv

fun calcSubs2(n: Long): Long {
    return if (n % 2 == 0L) {
        n / 2
    } else {
        ((n - smallestPrimeDiv(n)) / 2) + 1
    }
}

fun smallestPrimeDiv(n: Long): Long {
    when (n) {
        in 1L..7L step 2 -> return n
        else -> for (i in 3..Math.sqrt(n.toDouble()).toLong() step 2) {
            if (n % i == 0L) {
                return i
            }
        }
    }
    return n
}

fun main(args: Array<String>) {
    println(calcSubs2(readLine()!!.toLong()))
}