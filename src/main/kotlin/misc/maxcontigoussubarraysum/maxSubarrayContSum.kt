package misc.maxcontigoussubarraysum

import kotlin.math.max

/**
 * Dynamic Programming example for finding the maximum sum of a contigous subarray (O(n) runtime compl.)
 *
 * Note that this will handle also (entirely) negative arrays by returning their max element.
 * Indices are given inclusively (begin AND end)
 * */

fun maxSum(list:IntArray){
    var maxIfEndHere = list[0]
    var maxSum = list[0]
    var start = 0
    var s = 0
    var end = 0

    for(i in 1 until list.size){
        //maxIfEndHere = max(list[i], maxIfEndHere + list[i])
        if(list[i] >= maxIfEndHere + list[i]){
            maxIfEndHere = list[i]
            s = i
        }
        else maxIfEndHere += list[i]
        //maxSum = max(maxIfEndHere, maxSum)

        if(maxSum <= maxIfEndHere){
            maxSum = maxIfEndHere
            start = s
            end = i //end inclusive
        }
    }
    println("$maxSum starting at $start and ending at $end")
}

fun main(){
    maxSum(intArrayOf(-6,-5,-4,-3,-2,-1))
}