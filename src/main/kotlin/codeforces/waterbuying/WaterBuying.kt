package codeforces.waterbuying


fun minCost(n:Long, a:Int, b:Int) = if(a <= b/2) n * a else ((n/2)*b + (n%2)*a)

fun main(args:Array<String>){
    val q = readLine()!!.toInt()
    var count = 0
    var s: List<String>

    while(count < q){
         s = readLine()!!.split(" ")
        println(minCost(s[0].toLong(),s[1].toInt(),s[2].toInt()))
        count++
    }
}