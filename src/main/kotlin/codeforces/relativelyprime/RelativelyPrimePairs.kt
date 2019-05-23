package codeforces.relativelyprime

fun primePairs(l:Long, r:Long){
    println("YES")
    for(i in l until r step 2){
        println("$i ${i+1}")
    }
}

fun main(args:Array<String>){
    val s = readLine()!!.split(" ")
    primePairs(s[0].toLong(),s[1].toLong())
}