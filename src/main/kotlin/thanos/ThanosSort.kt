package thanos

class ThanosSort {

    fun thanosSort(array:MutableList<Int>):Int{
        return when {
            array.size == 1 -> 1
            isSorted(array) -> array.size
            else -> thanosSort(array.subList(0,array.size/2))
        }
    }


    private fun isSorted(array:MutableList<Int>):Boolean{
        var i = 0
        while(i <= array.size-2){
            if(array[i] > array[i+1]){
                return false
            }
            i++
        }
        return true
    }

    fun thanos(elements:MutableList<Int>):MutableList<Int>{
        return when {
            isSorted(elements) -> elements
            else -> thanos(elements.subList(0,elements.size/2))
        }
    }
}

fun main(){
    val obj = ThanosSort()
    println(obj.thanos(mutableListOf(11, 12, 13,14,15,17,14 ,1, 2, 13, 14, 3, 4, 5)))
}