package leetcode.rangeaddition

import kotlin.math.min


fun maxCount(m: Int, n: Int, ops: Array<IntArray>): Int {
    var minM = m
    var minN = n

    for (i in 0 until ops.size){
        minM = min(minM,ops[i][0])
        minN = min(minN,ops[i][1])
    }
    return minM * minN
}


fun main(){
    println(maxCount(3,3, arrayOf(intArrayOf(2,2), intArrayOf(3,3))))
}