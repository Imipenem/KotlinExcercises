package leetcode.uniquemorsecode

val map = hashMapOf( 'a' to ".-", 'b' to "-...", 'c' to "-.-.", 'd' to "-..", 'e' to ".", 'f' to "..-.", 'g' to "--.", 'h' to "....", 'i' to "..",
        'j' to ".---", 'k' to "-.-", 'l' to ".-..", 'm' to "--", 'n' to "-.",'o' to "---", 'p' to ".--.", 'q' to "--.-", 'r' to ".-.",
        's' to "...", 't' to "-", 'u' to "..-", 'v' to "...-", 'w' to ".--", 'x' to "-..-", 'y' to "-.--", 'z' to "--..")

val transformations = hashMapOf<String,Int>()

fun uniqueMorseRepresentations(words: Array<String>): Int {

    for(e in words) {
        val s = decode(e)
        if (!transformations.containsKey(s)) transformations[s] = 1
    }
    return transformations.size
}

fun decode(msg:String):String {
    var res = ""

    for(i in 0 until msg.length){
        res += map.getValue(msg[i])
    }
    return res
}


fun main(){
    println(uniqueMorseRepresentations(arrayOf("gin", "zen", "gig", "msg")))
}