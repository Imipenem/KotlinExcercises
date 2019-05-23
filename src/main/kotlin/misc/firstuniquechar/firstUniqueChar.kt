package misc.firstuniquechar

class firstUniqueChar {

    /*
    This method searches for the first non-repeating char in a given string
     */
    fun firstUnqiueCharInString(s: String): Char? {
        val map = HashMap<Char, Int?>()

        for (i in 0 until s.length) {
            if (!map.containsKey(s[i])) {
                map[s[i]] = 1
            } else {
                map[s[i]] = map[s[i]]!! + 1
            }
        }
        for (i in 0 until s.length) {
            if (map[s[i]] == 1) {
                return s[i]
            }
        }
        return null
    }
}

fun main(){
    val obj = firstUniqueChar()
    println(obj.firstUnqiueCharInString("firstUniqueChar"))
}