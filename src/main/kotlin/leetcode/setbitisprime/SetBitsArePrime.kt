package leetcode.setbitisprime

/**
 * This is for (possibly unlimited) number of set bits (although one may has to change to long/BigInteger)
 * Another (much more quicker approach due to the fact that R ist at most 10⁶) below.
 */


fun countPrimeSetBits(L: Int, R: Int): Int {
    val primes = sieve(R)
    var count = 0

    for (i in L..R) {
        val bits = Integer.toBinaryString(i).count { it == '1' }
        if (primes[bits]) count++
    }
    return count
}

fun sieve(n: Int): BooleanArray {
    var p = 2
    val sieve = BooleanArray(n)

    for (i in 2 until sieve.size) {
        sieve[i] = true
    }

    while (p * p < n) {
        if (sieve[p]) {
            for (j in p * p until sieve.size step p) {
                sieve[j] = false
            }
        }
        p++
    }
    return sieve
}

fun countSetBitsIsPrime2(L: Int, R: Int): Int {
    var count = 0
    for (i in L..R) {
        val bits = Integer.toBinaryString(i).count { it == '1' }
        if (bits == 2 || bits == 3 || bits == 5 || bits == 7 || bits == 11 ||
                bits == 13 || bits == 17 || bits == 19) count++
    }
    return count
}


fun main() {
    println(countPrimeSetBits(6, 15))
    println(countPrimeSetBits(6, 15))
}