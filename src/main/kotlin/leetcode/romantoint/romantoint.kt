package leetcode.romantoint

fun main(){
    val map = hashMapOf('I' to 1,'V' to 5,'X' to 10,'L' to 50,'C' to 100,'D' to 500,'M' to 1000)
    val s = "MCMXCIV"
    var i = 0
    var res = 0

    loop@ while( i < s.length){
        res+= map[s[i]]!!
        when{
            i == s.length-1 -> break@loop
            s[i] == 'I' && (s[i + 1] == 'V' || s[i + 1] == 'X') -> {
                res+= handleEdge(map[s[i + 1]]!!, 2)
                i++}
            s[i] == 'X' && (s[i + 1] == 'L' || s[i + 1] == 'C') -> {
                res+= handleEdge(map[s[i + 1]]!!, 20)
                i++}
            s[i] == 'C' && (s[i + 1] == 'D' || s[i + 1] == 'M')  -> {
                res += handleEdge(map[s[i + 1]]!!, 200)
                i++}
        }
        i++
    }
    print("$res")
}
fun handleEdge(nextVal:Int,sub:Int) = nextVal - sub