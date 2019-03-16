package twosum
import sumzero.Pair

class TwoSum {

    fun twosum(list:Array<Int>, target:Int):Pair<Int>{
        val map = HashMap<Int,Int>()
        for(i in 0 until list.size){
            if (map.containsKey(target-list[i])){
            return Pair(map[target-list[i]]!!,i)}

            else{
                map[list[i]] = i
            }
        }
        return Pair(Int.MIN_VALUE, Int.MAX_VALUE)
    }
}

fun main(){
    val obj = TwoSum()
    println(obj.twosum(arrayOf(4,5,8,9,7,8,9,4),8))
}