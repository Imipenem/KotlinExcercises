package leetcode.countbinarysubstrings

import kotlin.math.min


fun countBinarySubstrings(s: String): Int {
    var numA = 0
    var numB = 0
    var ind = 0
    var i = 0
    var res = 0

    while (true) {
        numA = 0
        while (i < s.length && s[ind] == s[i]) {
            numA++
            i++
        }
        res += min(numA, numB)
        if (i > s.length - 1) break
        numB = 0
        ind = i
        while (i < s.length && s[ind] == s[i]) {
            numB++
            i++
        }
        ind = i
        res += min(numA, numB)
        if (i > s.length - 1) break
    }

    return res
}

fun main() {
    println(countBinarySubstrings("000000000000000000000000000000000000000000001"))
}