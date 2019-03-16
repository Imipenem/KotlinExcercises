package validparanthesis

import java.util.*

class validParanthesis {

    fun isValid(s:String):Boolean {
        val s1: Stack<Char> = Stack()

        for (c in s) {
            if (c == '(' || c == '{' || c == '[') {
                s1.push(c)
            } else if (c == ')' && !s1.empty() && s1.peek() == '(') {
                s1.pop()
            } else if (c == '}' && !s1.empty() && s1.peek() == '{') {
                s1.pop()
            } else if (c == ']' && !s1.empty() && s1.peek() == '[') {
                s1.pop()
            } else {
                return false
            }
        }
        return s1.empty()
    }
}

fun main(){
    val obj = validParanthesis()
    println(obj.isValid("([)]"))
}