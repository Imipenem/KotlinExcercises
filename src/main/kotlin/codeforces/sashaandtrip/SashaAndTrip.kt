package codeforces.sashaandtrip

fun minMoney(n:Int, v:Int):Int{
    var count = 0
    var pos = 1

    if(n - 1 <= v){
        return n - 1
    }
    else {
        count += v

        while(n - pos > v){
            pos++
            count += pos
        }
    }
    return count
}

fun main(args:Array<String>){
    val s = readLine()!!.split(" ")
    println("${minMoney(s[0].toInt(), s[1].toInt())}")
}