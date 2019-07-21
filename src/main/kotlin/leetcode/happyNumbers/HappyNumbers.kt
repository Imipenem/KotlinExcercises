package leetcode.happyNumbers

import kotlin.math.sin


fun isHappy(n: Int): Boolean {

    var res = 0
    var num = n
    val map = hashMapOf<Int,Int>()

    while(num != 1){

        while(num != 0){
            res += (num%10)*(num%10)
            num /= 10
        }
        if(map.containsKey(res)) return false
        map[res] = 1
        num = res
        res = 0
    }
    return true
}

fun single(intArray: IntArray){
    var res = intArray[0]

    for(i in 1 until intArray.size){
        res = res.xor(intArray[i])
    }
    print(res)
}


fun main(){
    single(intArrayOf(2,300,5,4,300,5,4))
    println(isHappy(19))
}