package arraycoloring

fun colorArray(n:Int, k:Int, array:List<String>){

    val list = array.groupingBy { it.toInt() }.eachCount()
    val mapIndices = mutableMapOf<Int,Int>()
    var index = 1

    if(list.values.max()!! > k){
        println("NO")
        return
    }

    list.keys.forEach {
        if(!mapIndices.containsKey(it)){
            mapIndices[it] = index
            index += list.getValue(it)
        }
    }

    println("YES")
    for(e in array){
        val es = e.toInt()
        println("${((mapIndices[es]!!)%k)+1}")
        mapIndices[es] = ((mapIndices.getValue(es)%k+1))
    }
}

fun main(args:Array<String>){
    val nk = readLine()!!.split(" ")
    val array = readLine()!!.split(" ")
    colorArray(nk[0].toInt(), nk[1].toInt(), array)
}