package leetcode.nondecreasingarray

fun checkPossibility(nums: IntArray): Boolean {
    var p: Int? = null

    for(i in 0 until nums.size - 1){
        if(nums[i] > nums[i + 1]){
            if(p != null) return false
            p = i
        }
    }
    return p == null || p == 0 || p == nums.size - 2 || nums[p - 1] <= nums[p + 1] || nums[p] <= nums[p + 2]
}


fun main(){
    println(checkPossibility(intArrayOf(4,2,3)))
}