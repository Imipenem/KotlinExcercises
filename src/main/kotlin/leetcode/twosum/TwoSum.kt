package leetcode.twosum


fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = hashMapOf(nums[0] to 0)

    for(i in 1 until nums.size){
        if (map.containsKey(target - nums[i])) return intArrayOf(map.getValue(target - nums[i]), i)
        map[nums[i]] = i
    }
    return intArrayOf()
}

fun main(){
    for(e in twoSum(intArrayOf(3,2,4),6)){
        println(e)
    }
}