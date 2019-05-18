package codeforces.gourmetcat

import kotlin.math.max

fun maxDays(a:Int, b:Int, c:Int){
    val index = arrayOf(1,2,3,1,3,2,1)
    val fullWeeks = minOf(a/3,b/2,c/2) * 7
    var maxRemain = 0

    val newa = a - (fullWeeks/7)*3
    val newb = b - (fullWeeks/7)*2
    val newc = c - (fullWeeks/7)*2

    for(i in 0 until index.size){
        var ai = newa
        var bi = newb
        var ci = newc
        var cnt = 0
        var ind = i

        loop@ while(true){
            when(index[ind]){
                1 -> {if(ai <= 0){
                    break@loop
                }
                   else  ai--
                }
                2 -> {if(bi <= 0){
                    break@loop
                }
                else  bi--
                }
                3 -> {if(ci <= 0){
                    break@loop
                }
                else  ci--
                }
            }
            cnt++
            if(ind == index.size - 1){
                ind = 0
            }
            else {
                ind++
            }
        }
        maxRemain = max(cnt,maxRemain)
    }
    println("${fullWeeks+maxRemain}")
}

fun main(args:Array<String>){
    val l = readLine()!!.split(" ")
    maxDays(l[0].toInt(), l[1].toInt(), l[2].toInt())
}