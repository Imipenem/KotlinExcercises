package leetcode.lemonadechallenge


fun lemonade(bills:IntArray):Boolean{
    val map = hashMapOf<Int,Int?>(5 to 0, 10 to 0, 20 to 0)

    for(payment in bills){
        map[payment] = map[payment]?.plus(1)
        when(payment){
            10 -> if(map[5] == 0) return false else map[5] = map[5]?.minus(1)
            20 -> if(map[10]!! >= 1 && map[5]!! >= 1 ){
                        map[10] = map[10]?.minus(1)
                        map[5] = map[5]?.minus(1)
                    }
                  else if(map[5]!! >= 3) map[5] = map[5]?.minus(3)
                  else return false
        }
    }
    return true
}

fun main(){
    println(lemonade(intArrayOf(5,5,10,10,20)))
}