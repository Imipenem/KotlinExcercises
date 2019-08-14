package leetcode.faircandyswap

fun fairCandySwap(A: IntArray, B: IntArray): IntArray {
    val sumA = A.sum()
    var sumB = 0
    val map = HashMap<Int, Int>()
    var res = intArrayOf()

    for (e in B) {
        sumB += e
        if (!map.containsKey(e)) map[e] = 0
    }

    for (a in A) {
        if (map.containsKey(a + (sumB - sumA) / 2)) res = intArrayOf(a, a + (sumB - sumA) / 2)
    }
    return res
}


fun main() {
    println(fairCandySwap(intArrayOf(1, 2, 5), intArrayOf(2, 4))[0])
    println(fairCandySwap(intArrayOf(1, 2, 5), intArrayOf(2, 4))[1])
}