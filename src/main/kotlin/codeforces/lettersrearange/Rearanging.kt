package codeforces.lettersrearange

fun goodString(s: String) {
    if (!isPalindrom(s)) {
        println(s)
    } else {
        val first = s[0]
        for (i in 1 until s.length) {
            if (first != s[i]) {
                val temp = s.replaceRange(0, 1, s[i].toString())
                println(temp.replaceRange(i, i + 1, first.toString()))
                return
            }
        }
        println("-1")
    }

}

fun isPalindrom(s: String) = s == s.reversed()

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()

    for (i in 0 until t) {
        goodString(readLine()!!)
    }
}