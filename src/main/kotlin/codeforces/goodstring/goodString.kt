package codeforces.goodstring

fun goodString(n:Int, s:String){
    var count = 0
    var i = 0
    var j = s.length - 1

    while(s[i] != '>' && s[j] !='<'){
        count++
        i++
        j--
    }
    println("$count")
}

fun main(args:Array<String>){
    val q = readLine()!!.toInt()

    for(i in 0 until q){
        val n = readLine()!!.toInt()
        val s = readLine()!!
        goodString(n,s)
    }
}