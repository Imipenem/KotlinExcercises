package codeforces.baddays

import kotlin.math.max
import kotlin.math.min

private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

fun baddays(list:List<Int>){
    if(list.size <= 2){
        println("0")
        return
    }
    var baddays = 0
    var currNum:Int
    var max1 = max(list[0],list[1]) //highest seen value so far
    var max2 = min(list[0],list[1]) // second highest value seen so far

    for(i in 2 until list.size){
        currNum = list[i]

        if(currNum < max1 && currNum < max2){
            baddays++
        }
        else {
            when{
                max1 < currNum && max2 < currNum -> {
                    val t = max1
                    max1 = currNum
                    max2 = t
                }
                else -> max2 = currNum
            }
        }
    }
    println("$baddays")
}

fun main(args:Array<String>){
    val l = readInt()
    val days = readInts()
    baddays(days)
}