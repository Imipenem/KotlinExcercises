package dynamicprogramming.lnds

import kotlin.math.max

/**
 * Runtime Complexity: O(n^2) (since we have to do n O(n) traversals (from i to j))
 * Space Complexity: O(n)
 */

fun longestNonDecreasingSubsequence(nums:IntArray):Int?{

    /**
    Initialize res array with ones since the minimal possible answer in an non-empty array will be 1
     */
    val res = IntArray(nums.size){1}

    /**
     * For each element j in nums:
     * Regard all elements i in the array before j.
     * If i is lesser or equal to j decide wether its better to increase the actual subsequence length found up to i by one
     * OR take the max length at j, since this is even greater than i + 1
     *
     * Explanation: Above can occur if i is smaller than j but its also smaller than some elemnts before (so these cannot be
     * taken into account when it comes to the longest non decreasing subsequences length!
     */
    for(j in 1 until nums.size){
        for(i in 0 until j){
            if (nums[j] >= nums[i]) res[j] = max(res[i] + 1, res[j])
            //if (nums[j] > nums[i]) res[j] = max(res[i] + 1, res[j]) for longest INCREASING Subsequence
        }
    }
    return if (res.isEmpty()) 0 else res.max()
}


fun main() {
    println(longestNonDecreasingSubsequence(intArrayOf(-1,3,4,5,2,2,2,2))) //5
    println(longestNonDecreasingSubsequence(intArrayOf(-1,3,-10,5))) //3
    println(longestNonDecreasingSubsequence(intArrayOf(10,9,2,5,3,7,101,18))) //4
    println(longestNonDecreasingSubsequence(intArrayOf(10000))) //1
}