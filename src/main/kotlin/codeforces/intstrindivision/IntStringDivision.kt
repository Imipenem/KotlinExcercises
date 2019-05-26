package codeforces.intstrindivision


fun divideString(s:String){
    if(s.length == 2){
        when(s[1].toInt()){
            in 0..s[0].toInt() -> {
                println("NO")
            return}
            else -> {
                printHelper(s)
                return
            }
        }
    }
    printHelper(s)
}

fun printHelper(s:String){
    println("YES")
    println("2")
    val sub = s.substring(1)
    println("${s[0]} $sub")
}

fun main(args:Array<String>){
    val q = readLine()!!.toInt()

    for(i in 0 until q){
        val n = readLine()!!.toInt()
        val s = readLine()!!
        divideString(s)
    }
}