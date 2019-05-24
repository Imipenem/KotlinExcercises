package codeforces.powerOfTwo

class PowerOfTwo {

    fun power(n: Int, k: Int): MutableList<Double> {
        if (k > n || Integer.bitCount(n) > k) {
            return mutableListOf()
        } else {
            val s = Integer.toBinaryString(n)
            val list = mutableListOf<Double>()

            for (i in 0 until s.length) {
                if (s[i] == '1') {
                    list.add(Math.pow(2.0, s.length - 1 - i.toDouble()))
                }
            }
            var i = 0
            var curr = list.size
            while (curr < k) {
                while (list[i] == 1.0) {
                    if (i == list.size - 1) {
                        i = 0
                    }
                    else i++
                }
                list.add(list[i] / 2)
                list.add(list[i] / 2)
                list.removeAt(i)
                curr++
                if (i == list.size - 1) {
                    i = 0
                } else i++
            }
            return list
        }
    }
}

fun main() {
    val obj = PowerOfTwo()

    for (element in obj.power(15, 5)) {
        println(element.toInt())
    }
}