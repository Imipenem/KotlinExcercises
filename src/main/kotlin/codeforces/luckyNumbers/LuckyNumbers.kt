package codeforces.luckyNumbers

class LuckyNumbers {
    fun indexLucky(n:String):String{
        val ind = (1-(Math.pow(2.0,n.length.toDouble())))/(1-2)
        var result = ""
        for(i in 0 until n.length){
            result += if (n[i] == '4'){
                '0'
            } else '1'
        }
        return "Offset is ${ind.toInt()} + $result (binary)"
    }
}

fun main(){
    val obj = LuckyNumbers()
    println(obj.indexLucky("477"))
}