package codeforces.minimizeString

fun minimize(s:String):String{
    for((ind, i) in (1 until s.length).withIndex()){
        if(s[i] < s[ind]){
            return s.removeRange(ind,ind+1)
        }
    }
    return s.removeRange(s.length-1,s.length)
}

fun main(args:Array<String>){
    val n = readLine()
    println(minimize(readLine()!!))
}