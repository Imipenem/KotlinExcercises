package minint

fun minInt(l:Int,r:Int, d:Int) = if( d >= l) r+(d-(r%d)) else d

fun main(args:Array<String>){
    val q = readLine()!!.toInt()

    for(i in 0 until q){
        val s = readLine()!!.split(" ")
        println("${minInt(s[0].toInt(), s[1].toInt(), s[2].toInt())}")
    }
}