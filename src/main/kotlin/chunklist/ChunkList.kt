package chunklist

class ChunkList<T> {
    fun chunkList(list:List<T>, limit:Int):MutableList<List<T>> {
        val result = mutableListOf<List<T>>()

        for (i in 0..list.lastIndex step limit){

            val right = if (i + limit < list.size) i + limit else list.size
            result.add(list.subList(i,right))
        }
        return result
    }
}

fun main(){
    val obj = ChunkList<Int>()
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    for (e in obj.chunkList(list,3)){
        for (a in e){
            print("$a ")
        }
        println()
    }
}