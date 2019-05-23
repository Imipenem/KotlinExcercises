package misc.bubblesort

class BubbleSort {

    fun <E : Comparable<E>> bubbleSort(list: MutableList<E>): MutableList<E> {
        var n = list.size
        var currentValue: E

        while (n > 0) {
            currentValue = list[0]
            for (i in 1 until n) {
                if (currentValue > list[i]) {
                    val temp = list[i]
                    list[i] = currentValue
                    list[i - 1] = temp
                }
                currentValue = list[i]
            }
            n--
        }
        return list
    }
}

fun main() {
    val bubbleSort = BubbleSort()
    val intList = bubbleSort.bubbleSort(mutableListOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5))
    val charList = bubbleSort.bubbleSort(mutableListOf('M', 'O', 'O', 'n', 'e', 'r', 'o'))
    intList.forEach { println(it) }
    charList.forEach { println(it) }
}



