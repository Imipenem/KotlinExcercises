package codeforces.christmasornaments

import kotlin.math.min

fun beautifulTree(y:Int, b:Int, r:Int) = println("${min(y+2, min(b+1,r))*3 -3}")

fun main(args:Array<String>){
    val s = readLine()!!.split(" ")
    beautifulTree(s[0].toInt(), s[1].toInt(), s[2].toInt())
}