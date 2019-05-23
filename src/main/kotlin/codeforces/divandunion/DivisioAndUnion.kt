package codeforces.divandunion

data class Segment(val ini: Int, val end: Int, val index: Int)

fun divAndUnion(seq: List<Segment>) {
    val sortedSegments = seq.sortedWith(compareBy<Segment> { it.ini }.thenBy { it.end })
    for (i in 0 until sortedSegments.size) {
        TODO()
    }
}


fun main(args: Array<String>) {
    val t = readLine()!!.toInt()

    for (i in 0 until t) {
        val n = readLine()!!.toInt()
        val seq = mutableListOf<Segment>()
        for (j in 0 until n) {
            val s = readLine()!!.split(" ")
            seq.add(Segment(s[0].toInt(), s[1].toInt(), j))
        }
        divAndUnion(seq)
    }
}