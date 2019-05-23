package misc.arraypartition

class QuickSort<T : Comparable<T>> {

    /*
    QuickSort for lists in kotlin
     */
    fun quickSort(list: List<T>): List<T?> {

        if (list.count() < 2) {
            return list
        }

        val pivot = list[(0 until list.size).random()] // random number to lower worstCase probability

        val lesser = list.filter { it < pivot }
        val equals = list.filter { it == pivot }
        val higher = list.filter { it > pivot }

        return quickSort(lesser) + equals + quickSort(higher)
    }

    /*
    QuickSort for arrays in kotlin
     */

    fun quicksort(array: Array<T>, left: Int, right: Int) {
        val index = partition (array, left, right)
        if(left < index-1) { // 2) Sorting left half
            quicksort(array, left, index-1)
        }
        if(index < right) { // 3) Sorting right half
            quicksort(array,index, right)
        }
    }

    fun kthLargestElement(array: Array<T>, left: Int, right: Int, k:Int):T{
        val index = partition (array, left, right)

        if(index == k - 1){
            return array[k-1]
        }
        if(k-1 < index) { // 2) Sorting left half
           return kthLargestElement(array, left, index-1,k)
        }
        else { // 3) Sorting right half
            return kthLargestElement(array,index+1, right,k)
        }
    }

    fun partition(array: Array<T>, l: Int, r: Int): Int {
        var left = l
        var right = r
        val pivot = array[(left + right)/2] // 4) Pivot Point
        while (left <= right) {
            while (array[left] < pivot) left++ // 5) Find the elements on left that should be on right

            while (array[right] > pivot) right-- // 6) Find the elements on right that should be on left

            // 7) Swap elements, and move left and right indices
            if (left <= right) {
                swapArray(array, left,right)
                left++
                right--
            }
        }
        return left
    }

    fun swapArray(a: Array<T>, b: Int, c: Int) {
        val temp = a[b]
        a[b] = a[c]
        a[c] = temp
    }
}

fun main() {
    val obj = QuickSort<Char>()
    val obj2 = QuickSort<Int>()
    for (e in obj.quickSort(listOf('M', 'O', 'N', 'E', 'R', 'O', 'O', 'O'))) {
        print("$e ")
    }
    println("\n-------QuickSort Integer-----------------")
    val list = arrayOf(100, 104, 563, 900, 42, 57, 8, 6, 6, 234, 357, 789)
    obj2.quicksort(list,0,list.size-1)
    for (e in list) {
        print("$e ")
    }

    val obj3 = QuickSort<Int>()
    println("\n--------Find k-th smallest element-------------")
    println(obj3.kthLargestElement(arrayOf(100, 104, 563, 900, 42, 57, 8, 6, 6, 234, 357, 789),0,list.size-1,4))
}




