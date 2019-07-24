package leetcode.ispoweroftwo

fun isPowerOfTwo(n: Int) = n > 0 && Integer.toBinaryString(n).count { it == '1' } == 1

fun main(){
    println(isPowerOfTwo(1))
    println(isPowerOfTwo(2))
    println(isPowerOfTwo(4))
    println(isPowerOfTwo(8))
    println(isPowerOfTwo(1024))
    println(isPowerOfTwo(0))
    println(isPowerOfTwo(12345))
}