package findintegers

fun findTwoIntegers(list: List<String>) {
    val permutation = list.groupingBy { it.toInt() }.eachCount()
    val x = permutation.keys.max()!!.toInt()
    val adList = mutableListOf<Int>()


    for(i in list.indices) {
        if (x % list[i].toInt() != 0 || permutation.getValue(list[i].toInt())==2) {
            adList.add(list[i].toInt())

        }
    }
    println("$x ${adList.max()!!.toInt()}")
}

fun main(args: Array<String>) {
    val q = readLine()
    findTwoIntegers(readLine()!!.split(" "))
}