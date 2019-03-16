package containsduplicate

class ContainsDuplicate<T>{
    fun hasDuplicate(elements:Array<T>) = elements.distinct().size!=elements.size

    //a more straightforward way would be:

    fun hasDuplicate2(elements: Array<T>):Boolean{
        val map = HashMap<T,Int>()
        for (e in elements){
            if(!map.containsKey(e)){
                map[e] = 1
            }
            else{
                return true
            }
        }
        return false
    }
}

fun main(){
    val obj = ContainsDuplicate<Int>()
    println(obj.hasDuplicate(arrayOf(1,2,3,4,5,6,7,8,9,10)))
    println(obj.hasDuplicate(arrayOf(1,2,3,4,5,6,6,8,9,10)))
    println(obj.hasDuplicate(arrayOf(0,2,3,4,5,6,7,8,9,0)))
    println(obj.hasDuplicate(arrayOf(500,2,3,4,5,6,7,8,9,10)))

    println(obj.hasDuplicate2(arrayOf(1,2,3,4,5,6,7,8,9,10)))
    println(obj.hasDuplicate2(arrayOf(1,2,3,4,5,6,6,8,9,10)))
    println(obj.hasDuplicate2(arrayOf(0,2,3,4,5,6,7,8,9,0)))
    println(obj.hasDuplicate2(arrayOf(500,2,3,4,5,6,7,8,9,10)))
}