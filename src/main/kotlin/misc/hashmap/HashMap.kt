package misc.hashmap

import kotlin.math.abs

class Entry<K, V>(val key: K, val value: V, var next: Entry<K, V>? = null)

class HashMape<K, V> {
    private val INITIAL_CAPACITY = 16
    private val bucketList = Array<Entry<K, V>?>(INITIAL_CAPACITY) { null }
    var size = 0

    fun put(key: K, value: V) {
        val entry = Entry(key, value)
        val ind = abs(key.hashCode() % bucketList.size)
        size++

        if (bucketList[ind] == null) bucketList[ind] = entry
        else {
            var current = bucketList[ind]
            while (current?.next != null) {
                current = current.next
            }
            current?.next = entry
        }
    }

    fun getValue(key: K): V? {
        var current: Entry<K, V>? = bucketList[abs(key.hashCode() % bucketList.size)]

        while (current != null && current.key != key) {
            current = current.next
        }

        return current?.value
    }

    fun containsKey(key: K): Boolean {
        var current: Entry<K, V>? = bucketList[abs(key.hashCode() % bucketList.size)]

        while (current != null && current.key != key) {
            current = current.next
        }
        return current != null
    }

}

fun main() {
    val map = HashMape<String, Int>()

    map.put("ErsterEintrag", 1)
    map.put("ZweiterEintrag", 2)
    map.put("DritterEintrag", 3)
    map.put("VierterEintrag", 4)

    println(map.size) // 4?
    println(map.containsKey("ErsterEintrag")) //true
    println(map.containsKey("ZwoterEintrag")) //false

    println(map.getValue("VierterEintrag"))
    println(map.getValue("DrotterEintrag"))
}