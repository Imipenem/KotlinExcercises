package leetcode.validpalindrome


fun isPalindrome(s: String): Boolean {
    if(s.matches(Regex("[ -?]*"))) return true
    var l = 0
    var r = s.length - 1

    while(l < r){
        while(s[l].toInt() !in 65..122 && s[l].toInt() !in 48..57){
            l++
        }
        while(s[r].toInt() !in 65..122 && s[r].toInt() !in 48..57){
            r--
        }
        if(s[l].toLowerCase() != s[r].toLowerCase()) return false
        l++;r--
    }
    return true
}

fun helpCheckPalindrom(s: String): Boolean {
    var l = 0
    var r = s.length - 1

    while (l < r) {
        if (s[l] != s[r]) return false
        r--
        l++
    }
    return true
}

fun validPalindrome(s: String): Boolean {

    var l = 0
    var r = s.length - 1

    while (l < r) {

        if (s[l] != s[r]) return helpCheckPalindrom(s.substring(l, r)) || helpCheckPalindrom(s.substring(l + 1, r + 1))
        else {
            l++
            r--
        }
    }
    return true
}


fun main(){
    println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"))
}