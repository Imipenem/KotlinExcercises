package arraypartition

class ArrayPartition {

    /*
    This function partitionates an array in O(n) runtime and O(1) space.
     */

    

    fun partitionateArray(list:Array<Int>):Array<Int>{
        var pivot = 0 // position of the pivot element (initial set it to the first number)

        for(i in 1 until list.size){

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
        return list
    }
}

fun main(){
    val obj = ArrayPartition()
    val res = obj.partitionateArray(obj.partitionateArray(obj.partitionateArray(obj.partitionateArray(arrayOf(789, 104, 563, 900, 42, 57, 8, 6, 6, 234, 357, 100)))))
    for (e in res)
        println(e)
}

