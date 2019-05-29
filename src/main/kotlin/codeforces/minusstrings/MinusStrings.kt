package codeforces.minusstrings

private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

fun compareStrings(s:String,t:String):String{
    var currentStr = s
    for (i in 0 until t.length){
        when{
            t.length > currentStr.length -> return "NO"
            t[i] == '+' && currentStr[i] == '-' -> {
                if( i != currentStr.length - 1 && currentStr[i + 1] == '-'){
                    currentStr = currentStr.replaceRange(i,i+1,"+")
                    currentStr = currentStr.replaceRange(i+1, i+2, "")
                }
                else return "NO"
            }
            t[i] == '-' && currentStr[i] == '+' -> return "NO"
        }
    }
    return if(currentStr == t) "YES" else "NO"
}

fun main(args:Array<String>){
    val q = readInt()
    val list = mutableListOf<String>()

    for(i in 0 until q){
        val s = readLn()
        val t = readLn()
        list.add(i, compareStrings(s,t))
    }
    println(list.joinToString("\n"))
}