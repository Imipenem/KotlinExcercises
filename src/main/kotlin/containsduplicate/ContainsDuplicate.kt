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

    //checks wether there are two equal elements and their absoult difference is at most k
    fun hasDuplicateII(elements: Array<T>, k:Int):Boolean {
        val map = HashMap<T,Int>()
        for (e in elements){
            if (!map.containsKey(e)){
                map[e] = elements.indexOf(e)
            }
            else if (map.containsKey(e) && Math.abs(map[e]!!.minus(elements.lastIndexOf(e))) >= k){
                return true
            }
        }
        return false
    }

    fun hasDuplicateIII(elements: Array<T>, k:Int):Boolean {
        val map = HashMap<T,Int>()

        for (i in 0 until elements.size){
            if (map.containsKey(elements[i]) && Math.abs(map[elements[i]]!!.minus(i)) >= k) {
                return true
            }
            else {
                map[elements[i]] = i
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

    println(obj.hasDuplicateII(arrayOf(1,2,3,4,5,6,7,8,9,10),7))
    println(obj.hasDuplicateII(arrayOf(1,2,3,4,5,6,6,8,9,10),10))
    println(obj.hasDuplicateII(arrayOf(0,2,3,4,5,6,7,8,9,0),6))
    println(obj.hasDuplicateII(arrayOf(500,2,3,10,4,5,6,7,8,9,10),7))
    println(obj.hasDuplicateII(arrayOf(500,2,3,10,4,2,6,7,8,2,10),5))
    println(obj.hasDuplicateII(arrayOf(500,2,2,10,4,5,6,7,2,9,10),15))

    println(obj.hasDuplicateIII(arrayOf(1,2,3,4,5,6,7,8,9,10),7))
    println(obj.hasDuplicateIII(arrayOf(1,2,3,4,5,6,6,8,9,10),10))
    println(obj.hasDuplicateIII(arrayOf(0,2,3,4,5,6,7,8,9,0),6))
    println(obj.hasDuplicateIII(arrayOf(500,2,3,10,4,5,6,7,8,9,10),7))
    println(obj.hasDuplicateIII(arrayOf(500,2,3,10,4,2,6,7,8,2,10),5))
    println(obj.hasDuplicateIII(arrayOf(500,2,2,10,4,5,6,7,2,9,10),15))
}