package codeforces.divandunion

import kotlin.math.max

data class Segment(val ini: Int, val end: Int, val index: Int)

fun divAndUnion(seq: List<Segment>) {
    val sortedSegments = seq.sortedWith(compareBy<Segment> { it.ini }.thenBy { it.end })
    var isTwoNotEmpty = false
    val order = IntArray(sortedSegments.size)
    order[sortedSegments[0].index] = 1
    var maxEndOne = sortedSegments[0].end

    for (i in 1 until sortedSegments.size) {
        maxEndOne = max(maxEndOne,sortedSegments[i - 1].end)
        if(sortedSegments[i].ini <= maxEndOne && !isTwoNotEmpty){
            order[sortedSegments[i].index] = 1
        }
        else {
            isTwoNotEmpty = true
            order[sortedSegments[i].index] = 2
        }
    }

    if(isTwoNotEmpty){
        for(e in order){
            print("$e ")
        }
        print("\n")
    }
    else{
        println("-1")
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