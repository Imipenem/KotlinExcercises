package leetcode.mountainarray


fun validMountainArray(A: IntArray): Boolean {
    if(A.size < 3 || A[0] >= A[1]) return false

    var i = 0
    while(A[i] < A[i + 1]){
        if(i + 1 == A.size - 1) return false
        i++
    }
    for (j in i until A.size - 1){
        if(A[j] <= A[j + 1]) return false
    }
    return true
}

fun main(){

}