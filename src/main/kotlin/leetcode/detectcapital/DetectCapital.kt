package leetcode.detectcapital


fun detectCapitalUse(word: String) = word.matches(Regex("[a-z]*")) ||
        word.matches(Regex("[A-Z][a-z]*")) || word.matches(Regex("[A-Z]*"))

fun main() {
    println(detectCapitalUse("USA"))
    println(detectCapitalUse("FlaG"))
    println(detectCapitalUse("leetcode"))
    println(detectCapitalUse("Google"))
}