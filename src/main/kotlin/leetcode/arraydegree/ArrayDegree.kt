package leetcode.arraydegree

import kotlin.math.min

fun findShortestSubArray(nums: IntArray): Int {

    val numsCount = hashMapOf<Int,Int>()
    val leftBound = hashMapOf<Int,Int>()
    val rightBound = hashMapOf<Int,Int>()

    for(i in 0 until nums.size ){
        if(!numsCount.containsKey(nums[i])){
            numsCount[nums[i]] = 1
            leftBound[nums[i]] = i
            rightBound[nums[i]] = i
        }
        else {
            numsCount[nums[i]] = numsCount.getValue(nums[i]) + 1
            rightBound[nums[i]] = i
        }
    }
    val degree = numsCount.values.max() // may move this on for loop above?
    var minSubarray = Integer.MAX_VALUE

    for(e in numsCount.keys){
        if(numsCount.getValue(e) == degree){
            minSubarray = min(minSubarray,(rightBound.getValue(e) - leftBound.getValue(e)) + 1)
        }
    }
    return minSubarray
}

fun main(){
    println(findShortestSubArray(intArrayOf(1,2,7,3,8,4,6)))
}