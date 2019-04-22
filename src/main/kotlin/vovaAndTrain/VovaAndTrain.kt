package vovaAndTrain

fun seeLaterns(L: Int, v: Int, l: Int, r: Int) = (L / v) - ((r / v) - (l - 1) / v)

fun main(args: Array<String>) {
    val t = readLine()
    var s = readLine()
    while (s != null) {
        val array = s.split(" ")
        println(seeLaterns(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]), Integer.parseInt(array[3])))
        s = readLine()
    }
}