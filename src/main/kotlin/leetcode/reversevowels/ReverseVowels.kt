package leetcode.reversevowels


fun reverseVowels(s: String): String {
    var l = 0
    var r = s.length - 1
    val res = s.toCharArray()

    while (l < r) {
        while (l < r && !isVowel(res[l])) {
            l++
        }

        while (r > l && !isVowel(res[r])) {
            r--
        }

        if (l < r) {
            val temp = res[r]
            res[r] = res[l]
            res[l] = temp
            l++
            r--
        }
    }
    return res.joinToString("")
}

fun isVowel(c: Char) = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'


fun main() {
    println(reverseVowels("hello"))
    println(reverseVowels("leetcode"))
}