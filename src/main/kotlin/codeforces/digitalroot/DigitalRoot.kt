package codeforces.digitalroot

fun root(k:Long, x:Long) = x + (k-1L) * 9L

fun main(){
    val q = readLine()!!.toInt()

    for (i in 0 until q){
        val xk = readLine()!!.split(" ")
        println(root(xk[0].toLong(), xk[1].toLong()))
    }
}