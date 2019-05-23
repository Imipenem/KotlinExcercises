package misc.sumzero

class Sumzero {
    /**
     * return a pair (if any) whose values summed up equal zero else null
     */
    fun firstSumZero(list: MutableList<Int>): Pair<Int>? {
        var firstPointer = 0
        var secondPointer = list.lastIndex
        while (secondPointer > firstPointer) {
            if (Math.abs(list[firstPointer]) != list[secondPointer]) {
                if (Math.abs(list[firstPointer]) > list[secondPointer]) firstPointer++ else secondPointer--
            } else return Pair(list[firstPointer], list[secondPointer])
        }
        return null
    }
}

fun main() {
    val test = Sumzero()
    print(test.firstSumZero(mutableListOf(-10, -9, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 11)))
}