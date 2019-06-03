package leetcode.bannedwords

fun count(s:String,a:Array<String>):String{
    var currMax = 0
    var maxWord = ""
    var currWord = ""
    val splitted:Map<String,Int>
    val split = mutableListOf<String>()

    for(i in 0 until s.length){
        when{
            s[i] == '!' || s[i] == '?' || s[i] == '\'' || s[i] == ',' || s[i] == '.' || s[i] == ';' -> {
                split.add(currWord)
                currWord = ""
            }
            s[i] == ' ' || i == s.length-1 -> {
                if(i==s.length-1){
                    currWord+=s[i].toLowerCase()
                }
                if (currWord.isNotEmpty()) {split.add(currWord)}
                currWord = ""}
            else -> currWord+=s[i].toLowerCase()
        }
    }
    splitted = split.groupingBy { it }.eachCount()

    for(e in splitted){
        if(!a.contains(e.key)&&e.value > currMax){
            maxWord = e.key
            currMax = e.value
        }
    }
    return maxWord
}

fun main(args:Array<String>){
    val s = "abc!;"
    val a = arrayOf("")
    println(count(s,a))
}