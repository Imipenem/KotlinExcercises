package leetcode.reversenumber

import kotlin.math.abs
import kotlin.math.pow

fun reverse(x: Int): Int {
    var n = x
    var num = 0

    while(n > 0 || n < 0){
        if(num > Int.MAX_VALUE/10 || num==Int.MAX_VALUE/10 && n%10 > 7) return 0
        else if(num < Int.MIN_VALUE/10 || num==Int.MIN_VALUE/10 && n < -8) return 0
        num = num * 10 + abs(n%10)
        n/=10
    }
    return if(x < 0) -num else num
}


fun main(){
    println(reverse(-12345))
    println(reverse((-2.0).pow(31.0).toInt()))
    println(reverse(12345678))

}