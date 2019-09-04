package leetcode.longestpalindrom


fun longestPalindrome(s: String): Int {
    val map = s.groupingBy { it }.eachCount()
    var res = 0

    for (key in map) {
        res += if (key.value % 2 == 0) key.value else key.value - 1
    }

    return if (res < s.length) res + 1 else res
}


fun main() {
    print(longestPalindrome("aaab"))
}