package misc.arraypartition

class ArrayPartition {

    fun quickSort(array: Array<Int>, left: Int, right: Int) {
        val index = partitionateArray (array)
        if(left < index-1) { // 2) Sorting left half
            quickSort(array, left, index-1)
        }
        if(index < right) { // 3) Sorting right half
            quickSort(array,index, right)
        }
    }

    /*
    This function partitionates an array in O(n) runtime and O(1) space.
     */
    fun partitionateArray(list:Array<Int>):Int{
        var pivot = 0 // position of the pivot element (initial set it to the first number of the list)

        for(i in pivot+1 until list.size){

            if(list[i] > list[pivot]){
                continue
            }
            else {
                val temp = list[pivot]
                list[pivot] = list[i]
                list[i] = list[pivot + 1]
                list[pivot + 1] = temp
                pivot++
            }
        }
        return pivot
    }
}

fun main(){
    val obj = ArrayPartition()
    val array = arrayOf(789, 104, 563, 900, 42, 57, 8, 6, 6, 234, 357, 100)
    obj.quickSort(array,0,array.size-1)
    for (e in array)
        println(e)
}

