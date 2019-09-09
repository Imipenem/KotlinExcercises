package leetcode.flipandinvertimage


fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
    val res = A
    var l = 0
    var r = A.size - 1

    for (row in 0 until A.size) {
        while (l < r) {
            val temp = res[row][l].xor(1) //flip and invert
            res[row][l] = res[row][r].xor(1) //flip and invert
            res[row][r] = temp
            r--
            l++
        }
        if (l == r) res[row][r] = res[row][r].xor(1)
        l = 0
        r = A.size - 1
    }
    return res
}


fun main() {
    val res = flipAndInvertImage(arrayOf(intArrayOf(1, 1, 0, 0), intArrayOf(1, 0, 0, 1), intArrayOf(0, 1, 1, 1), intArrayOf(1, 0, 1, 0)))
    for (row in 0 until res.size) {
        for (col in 0 until res[row].size) {
            print(res[row][col])
        }
        print("\n")
    }
}