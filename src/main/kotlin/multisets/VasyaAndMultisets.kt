package multisets

fun niceMultisets(c: List<String?>) {
    val list = c.groupingBy { it }.eachCount()
    val niceNumbers = list.filterValues { it == 1 }
    val others = list.filterValues { it > 2 }

    if (niceNumbers.size % 2 == 0) {
        println("YES")
        var count = 0
        for (e in c) {
            if (!niceNumbers.containsKey(e)) {
                print("A")
            } else {
                count = (count + 1) % 2
                when (count) {
                    0 -> print("A")
                    1 -> print("B")
                }
            }
        }
    } else {
        if (others.isEmpty()) {
            print("NO")
        } else {
            println("YES")
            var niceIndex = 0
            var firstOccur = true

            for (i in 0 until c.size) {
                if (niceIndex < niceNumbers.size / 2 && niceNumbers.containsKey(c[i])) {
                    print("A")
                    niceIndex++
                } else if (niceIndex >= niceNumbers.size / 2 && niceNumbers.containsKey(c[i])) {
                    print("B")
                } else if (firstOccur && others.containsKey(c[i])) {
                    print("A")
                    firstOccur = !firstOccur
                } else {
                    print("B")
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    val n = readLine()
    niceMultisets(readLine()!!.split(" "))
}


fun hallo() {
    var count = 0
    //for (e in list){
    //  if(e.value==1){
    //    count++
    //  }
    //}
}