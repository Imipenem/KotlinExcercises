package codeforces.threeints

import kotlin.math.max
import kotlin.math.min

private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

fun threeInts(x:Int, y:Int) = "${x - (y-1)} ${y - 1} 1"

fun main(args:Array<String>){
    val q = readInt()

    for(i in 0 until q){
        val(x,y) = readInts()
        println(threeInts(max(x,y),(min(x,y))))
    }
}