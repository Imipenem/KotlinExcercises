package leetcode.ispoweroffour


fun isPowerOfFour(num: Int) = num > 0 && (num.and(num - 1) == 0) && Integer.toBinaryString(num).length % 2 == 1


fun main(){
    println(isPowerOfFour(0))
    println(isPowerOfFour(1))
            println(isPowerOfFour(2))
            println(isPowerOfFour(4))
    println(isPowerOfFour(16))
            println(isPowerOfFour(256))
}