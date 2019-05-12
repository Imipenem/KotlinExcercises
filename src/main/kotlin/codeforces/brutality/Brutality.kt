package codeforces.brutality

fun brutal(n:Int,k:Int, num:List<String>, s:String){
    var l = 0
    var r = 0
    var list = mutableListOf<Int>()
    var maxDMG = 0L

    while( l < s.length){
        while( r < s.length && s[l]==s[r]){
            list.add(num[r].toInt())
            r++
        }

        if(list.size <= k){
            list.forEach { maxDMG+= it }
        }

        else {
            list.sortDescending()

            for(i in 0 until k){
                maxDMG+=list[i]
            }
        }
        l = r
        list = mutableListOf()
    }
    println("$maxDMG")
}

fun main(args:Array<String>){

    val q = readLine()!!.split(" ")
    val numbers = readLine()!!.split(" ")
    val s = readLine()!!
    brutal(q[0].toInt(),q[1].toInt(), numbers,s)
}