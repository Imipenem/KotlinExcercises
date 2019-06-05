package leetcode.houserobber

/*
    LeetCode Exercise 198: House Robber
 */

import kotlin.math.max


fun rob(nums:IntArray):Int{
    when(nums.size){
        0 -> return 0
        1 -> return nums[0]
        2 -> return max(nums[0], nums[1])
    }
    val size = nums.size
    val dp = mutableListOf<Int>()
    dp.add(0,nums[0])
    dp.add(1,(max(nums[0],nums[1])))

    for(i in 2 until size){
        dp.add(i,max(dp[i-1], dp[i-2] + nums[i]))
    }
    return dp[size - 1]
}


fun main(args:Array<String>){
    println(rob(intArrayOf(2,7,9,3,1)))
}