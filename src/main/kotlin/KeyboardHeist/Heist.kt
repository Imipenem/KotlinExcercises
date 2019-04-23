package KeyboardHeist

fun originalKeyboards(max: Int, min: Int, n: Int) = (max + 1) - min - n

fun calcMaxAndMin(numbers: List<String>?): Pair<Int, Int> {
    var max = numbers!![0].toInt()
    var min = numbers[0].toInt()

    for (i in 1 until numbers.size) {
        val currNum = numbers[i].toInt()
        when {
            currNum < min -> min = currNum
            currNum > max -> max = currNum
        }
    }
    return Pair(min, max)
}

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val numbers = readLine()?.split(" ")
    val (min, max) = calcMaxAndMin(numbers)
    println(originalKeyboards(max, min, n))
}