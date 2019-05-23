package misc.groupanagrams

import java.util.*

class GroupAnagrams {

    fun groupAnagrams(array: Array<String>) {
        val map = HashMap<Int, MutableList<String>>()
        for (i in 0 until array.size) {

            val word = array[i]
            val chars = word.toCharArray()
            Arrays.sort(chars)
            val newWord = String(chars)
            val hash = newWord.hashCode() //the hashcode of the new String object

            if (!map.containsKey(hash)) {
                map[hash] = mutableListOf()
            }

            map.getValue(hash).add(word)
        }

        map.forEach { (_, value) ->
            run {
                value.forEach { println(it) }
                println("-------------------")
            }
        }
    }
}

fun main() {
    val obj = GroupAnagrams()
    obj.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
}