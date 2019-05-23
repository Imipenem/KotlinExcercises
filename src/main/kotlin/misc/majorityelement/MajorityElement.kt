package misc.majorityelement

class MajorityElement {
    //assume that the majority element always exists and array is non-empty
    //another approach would be using a HashMap and populate it with the array data
    fun findMajorityElement(list:Array<Int>):Int?{
        val s = list.filter { it in list }.groupBy { it }
        val high = s.maxWith(Comparator{ o1, o2 ->
            when {
                o1.value.size > o2.value.size -> 1
                o1.value.size == o2.value.size -> 0
                else -> -1
            }
        })
        return high?.value?.get(0)
    }
}
fun main (){
    val MajorityElement=MajorityElement()
    println(MajorityElement.findMajorityElement(arrayOf(9,8,7,10,14,15,15,15,15,10,10,10,10,10)))
}