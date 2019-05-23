package codeforces.grapes


fun anyGrapes(want: List<String>, grapes: List<String>) {
    if (want[0].toInt() - grapes[0].toInt() > 0) {
        println("NO")
    } else {
        val greenRem = grapes[0].toInt() - want[0].toInt()
        val micha = if ((want[2].toInt() - grapes[2].toInt()) < 0) {
            0
        } else {
            want[2].toInt() - grapes[2].toInt()
        }

        if (greenRem + grapes[1].toInt() >= (micha + want[1].toInt())) {
            println("YES")
            return
        }
        println("NO")
    }
}

fun main(args: Array<String>) {
    val want = readLine()!!.split(" ")
    val grapes = readLine()!!.split(" ")
    anyGrapes(want, grapes)
}