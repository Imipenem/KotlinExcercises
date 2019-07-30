package leetcode.palindromicnumber

/**
 * Determine whether a number is a palindrom without string conversion
 */

fun isPalindrome(x: Int): Boolean {
    var reverse = 0
    var num = x

    while(num > 0){
        reverse = reverse*10 + num % 10
        num /= 10
    }
    return reverse == x
}

fun main(){
    println(isPalindrome(12233221))
}