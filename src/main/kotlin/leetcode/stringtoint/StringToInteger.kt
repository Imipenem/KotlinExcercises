package leetcode.stringtoint

fun myAtoi(str: String): Int {
    var ind = 0
    var num = 0
    var sign = 1

    if (str.isEmpty()) return 0

    while (ind < str.length && str[ind] == ' ') {
        ind++
    }
    when {
        ind == str.length -> return 0
        str[ind] == '-' -> {
            sign = -1
            ind++
        }
        str[ind] == '+' -> ind++
    }

    if (ind == str.length || str[ind] !in '0'..'9') return 0


    while (ind < str.length && str[ind] in '0'..'9') {
        val digit = (str[ind] - '0') * sign

        if (num > Int.MAX_VALUE / 10 || num == Int.MAX_VALUE / 10 && digit > 7) return Int.MAX_VALUE
        else if (num < Int.MIN_VALUE / 10 || num == Int.MIN_VALUE / 10 && digit < -8) return Int.MIN_VALUE

        num = num * 10 + digit
        ind++
    }
    return num
}

fun main() {
    println(myAtoi("-12345"))
    println(myAtoi("-1"))
    println(myAtoi("-238476"))
    println(myAtoi("-8888"))
    println(myAtoi("-1 andISayHow"))
    println(myAtoi("    -8437Iskdks"))
    println(myAtoi("12345"))
    println(myAtoi("4"))
    println(myAtoi("3248324832843298"))
    println(myAtoi(""))
    println(myAtoi("     1Abrakeydabra"))
    println(myAtoi("   t84384939  "))
}