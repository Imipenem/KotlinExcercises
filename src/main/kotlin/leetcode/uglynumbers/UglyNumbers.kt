package leetcode.uglynumbers

/*
    263. Ugly Number : LeetCode Exercise
 */

fun isUgly(num: Int): Boolean {
    if(num < 1) return false

    var x = num
    while(x % 2 == 0) x=x.shr(1)
    while (x % 3 == 0) x /= 3
    while(x % 5 == 0) x /= 5
    return x == 1
}

fun main(){
    println(isUgly(6))
    println(isUgly(8))
    println(isUgly(14))
    println(isUgly(108))
    println(isUgly(98))
}