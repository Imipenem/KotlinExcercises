package leetcode.distringmatch


fun diStringMatch(S: String): IntArray {
    var h  = S.length
    var l = 0
    val res = mutableListOf<Int>()

    for(i in 0 until S.length){
        if(S[i] == 'I') res.add(l++)
        else res.add(h--)
    }
    res.add(l)
    return res.toIntArray()
}

fun main(){
    for (e in diStringMatch("IDID")) print(e)
    println()
    for (e in diStringMatch("III")) print(e)
    println()
    for (e in diStringMatch("DDI")) print(e)
}