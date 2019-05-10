package bacteriaBitmask

class Bacteria {

    fun minBacteria(n:Int):Int{
        var count = 0
        val mask = Integer.toBinaryString(n)
        for (i in 0 until mask.length){
            if(mask[i] == '1'){
                count++
            }
        }
        return count
    }
}


fun main() {
    val obj = Bacteria()
    println(obj.minBacteria(8))
}
