package leetcode.toeplitzmatrix

fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {

    if(matrix.size == 1 || matrix[0].size == 1) return true

    var firstInd = 0
    var secInd = 1
    var firstRow:IntArray
    var secRow:IntArray

    while(secInd < matrix.size){
        firstRow = matrix[firstInd]
        secRow = matrix[secInd]

        for(i in 1 until secRow.size){
            if(secRow[i] != firstRow[i-1]) return false
        }
        firstInd = secInd
        secInd++
    }
    return true
}

fun main(){
    val row1 = intArrayOf(1,2)
    val row2 = intArrayOf(2,2)
    val row3 = intArrayOf(9,5,1,2)

    val matrix = arrayOf(row1,row2)

    println(isToeplitzMatrix(matrix))
}