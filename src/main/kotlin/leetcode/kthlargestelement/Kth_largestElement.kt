package leetcode.kthlargestelement

import java.util.*

fun findKthLargest(nums: IntArray, k: Int): Int {

    val set = TreeSet<Int>()

    for (i in 0 until nums.size) {
        set.add(nums[i])

        if (set.size > k) set.remove(set.first())
    }
    return set.first()
}


fun main() {
    println(findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    println(findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 3))
}