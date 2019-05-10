package findpair

fun findPair(){

}

fun main(args:Array<String>){
    val t = readLine()!!.toInt()
    var count = 0
    var s:List<String>

    while (count < t){
        s = readLine()!!.split(" ")
        println("${s[0]} ${s[0].toInt()*2}")
        count++
    }
}