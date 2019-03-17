package sum3

class Sum3 {

    /*
    This function returns all triplets with digits added together equal 0
    That means: a+b+c=0 where a,b,c elementOf the input array.
    This algorithm runs in O(n^2) using the two-pointers approach
     */

    fun sum3(array: Array<Int>): List<Int> {
        array.sort()
        var fixedPointer = 0
        var beginPointer = 1
        var endPointer: Int = array.size - 1
        val resultList: MutableList<Int> = ArrayList()

        while (fixedPointer < array.size - 2) {
            while (beginPointer < endPointer) {
                when {
                    (array[beginPointer] + array[endPointer]) < -(array[fixedPointer]) -> beginPointer++
                    (array[beginPointer] + array[endPointer]) > -(array[fixedPointer]) -> endPointer--
                    else -> {
                        resultList.add(array[fixedPointer])
                        resultList.add(array[beginPointer])
                        resultList.add(array[endPointer])
                        beginPointer++
                    }
                }
            }
            fixedPointer++
            beginPointer = fixedPointer + 1
            endPointer = array.size - 1
        }
        return resultList
    }
}

fun main() {
    val obj = Sum3()
    val result = obj.sum3(arrayOf(-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    for (e in result) {
        println(e)
    }
}