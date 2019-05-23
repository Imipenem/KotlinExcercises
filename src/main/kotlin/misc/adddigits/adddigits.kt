package misc.adddigits

class addDigits{
    fun addDigits(num:Int):String{
        var numberAsString = num.toString()
        var result=0
        while(numberAsString.length > 1){
            for (c in numberAsString){
                result+=c.toInt()-48
            }
            numberAsString=result.toString()
            result=0
        }
        return numberAsString
    }
}
// do this without loops in O(1) runtime???
    fun addDigitsWithoutLoops(num: Int): Int = when{
        num == 0 -> 0
        num % 9 == 0 -> 9
        else -> num%9
}

fun main(){
    val addDigits = addDigits()
    println(addDigits.addDigits(38) == addDigitsWithoutLoops(38).toString())
    println(addDigits.addDigits(105) == addDigitsWithoutLoops(105).toString())
    println(addDigits.addDigits(40) == addDigitsWithoutLoops(40).toString())
    println(addDigits.addDigits(1537546) == addDigitsWithoutLoops(1537546).toString())
    println(addDigits.addDigits(0) == addDigitsWithoutLoops(0).toString())
}