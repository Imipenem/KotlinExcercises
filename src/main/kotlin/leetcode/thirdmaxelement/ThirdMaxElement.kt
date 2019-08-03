package leetcode.thirdmaxelement

import java.util.*

fun thirdMax(nums: IntArray): Int {
    val set = TreeSet<Int>()

    for (i in 0 until nums.size) {
        set.add(nums[i])

        if (set.size > 3) set.remove(set.first())
    }
    return if (set.size < 3) set.last() else set.first()
}


fun main() {
    println(thirdMax(intArrayOf(2, 1)))
    println(thirdMax(intArrayOf(2, 2, 3, 1)))
    println(thirdMax(intArrayOf(3, 2, 1)))
}