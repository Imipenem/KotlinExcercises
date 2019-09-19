package leetcode.matchingsubsequences

fun numMatchingSubseq(S: String, words: Array<String>): Int {
    var count = 0

    for (e in words) {
        if (isSubsequence(S, e)) count++
    }
    return count
}

fun isSubsequence(s: String, s1: String): Boolean {
    var pointerS1 = 0
    var pointerS = 0

    while (pointerS1 < s1.length) {
        for (i in pointerS until s.length) {
            if (i == s.length - 1 && s[i] != s1[pointerS1]) return false
            else if (s[i] == s1[pointerS1]) {
                pointerS1++
                pointerS = i + 1
                break
            }
        }
    }
    return true

}

fun main() {
    println(numMatchingSubseq("abcde", arrayOf("a", "bb", "acd", "ace")))
}