package leetcode.shortesword


fun shortest(licensePlate: String, words: Array<String>):String{
    var licensePlate = licensePlate
    var min = Integer.MAX_VALUE
    var res = ""
    licensePlate = licensePlate.replace(Regex("( )*[0-9]*"),"").toLowerCase()

    val licenseMap = licensePlate.groupingBy { it }.eachCount()

    for(s in words){
        var isValid = true
        val str = s.toLowerCase()
        val strMap = str.groupingBy { it }.eachCount()

        loop@ for(char in licenseMap){
            if(!strMap.containsKey(char.key) || strMap.getValue(char.key) < licenseMap.getValue(char.key)) {
                isValid = false
                break@loop
            }
        }
        if(isValid){
            if(s.length < min){
                res = s
                min = s.length
            }
        }
    }
    return res
}

fun main(){
    println(shortest("1s3 456", arrayOf("looks", "pest", "stew", "show")))
}