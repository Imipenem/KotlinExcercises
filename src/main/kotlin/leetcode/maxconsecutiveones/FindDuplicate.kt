package leetcode.maxconsecutiveones

import kotlin.math.max

fun findMaxConsecutiveOnes(nums: IntArray): Int {

    var maxOnes = 0
    var current = 0
    if (nums.size == 1) return nums[0]

    for (i in 0 until nums.size) {
        if (nums[i] == 1 && i != nums.size - 1) current++
        else {
            if (i == nums.size - 1 && nums[i] == 1) current++
            maxOnes = max(maxOnes, current)
            current = 0
        }
    }
    return maxOnes
}

fun main() {

}