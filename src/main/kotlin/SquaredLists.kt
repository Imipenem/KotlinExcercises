/**
 * This function returns true, only if the second list contains all (frequencies must match too) squared numbers of the first one
 */
fun isSquaredList(list1:MutableList<Int>, list2:MutableList<Int>):Boolean{
    list1.forEach { if (it * it in list2) list2.remove(it *it) else return false}
    return true
}
/**
fun isSquaredList2(list1:MutableList<Int>, list2:MutableList<Int>):Boolean{
    val helper = list1.map { it * it }
            .groupBy { it }

   val helper2 =list2.groupBy { it }

    return helper == helper2
}
*/
fun main(){
println(isSquaredList(mutableListOf(1,2,4), mutableListOf(1,4,16,14)))
}