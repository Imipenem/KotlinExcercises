package dynamicprogramming.frog

import kotlin.math.min


fun frog(nums:IntArray):Int{
    when(nums.size){
        in 0..1 -> return 0
        2 -> return Math.abs(nums[0] - nums[1])
        3 -> return Math.abs(nums[0]- nums[2])
    }

    val size = nums.size
    val dp = mutableListOf<Int>()
    dp.add(0,0) // the first "2er" step
    dp.add(1,Math.abs(nums[0] - nums[1])) // the first "1ner" step

    /**
        Repeatly do the following:

        Check whether its more optimal to a 1ner Step or a 2er Step from the last respectively the last - 1 item
        to reach a local Optimum (Minimum in this case)
     */

    for(i in 2 until size){
        dp.add(i, min(dp[i-1]+ Math.abs(nums[i] - nums[i-1]), dp[i-2] + Math.abs(nums[i] - nums[i-2])))
    }
    return dp[size - 1]
}



fun main(){
    println(frog(intArrayOf(10,30,40,20)))
}