package leetcode.maxperimeter

fun largestPerimeter(A: IntArray): Int {
    A.sortDescending()
    for(i in 0 until A.size - 2){
        if(A[i] < A[i + 1] + A[i + 2]) return A[i] + A[i + 1] + A[i + 2]
    }
    return 0
}


fun main(){
    println(largestPerimeter(intArrayOf(3,6,2,3)))
}