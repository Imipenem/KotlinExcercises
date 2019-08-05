package leetcode.robottoorigin

fun judgeCircle(moves: String): Boolean {
    val map = hashMapOf('L' to 0, 'R' to 0, 'U' to 0, 'D' to 0)
    moves.groupingBy { it }.eachCountTo(map).also { return map.getValue('L') == map.getValue('R') && map.getValue('U') == map.getValue('D') }
}

fun main() {
    println(judgeCircle("UD"))
    println(judgeCircle("LL"))
}