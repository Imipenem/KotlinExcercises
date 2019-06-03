package leetcode.wordpattern


fun matchesPattern(pattern:String, str:String):Boolean{
    val map = hashMapOf<Char,String>()
    val words = str.split(" ")

    for(i in 0 until pattern.length){
        if(!map.containsKey(pattern[i])){
            if(i >= words.size || map.containsValue(words[i])){
                return false
            }
            map[pattern[i]] = words[i]
        }
        else if(map[pattern[i]] != words[i]) {
            return false
        }
    }
    return words.size == pattern.length
}


fun main(args:Array<String>){
    println(matchesPattern("","dog"))
}