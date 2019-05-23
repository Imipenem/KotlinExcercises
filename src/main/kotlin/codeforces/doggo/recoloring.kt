package codeforces.doggo

fun doggo(s: String) {
    val map = hashMapOf<Char, Int>()
    s.forEach {
        if (map.containsKey(it)) {
            print("YES")
            return
        } else map[it] = 1
    }
    println("NO")
}

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    if (s.length == 1) {
        println("YES")
    } else doggo(s)
}