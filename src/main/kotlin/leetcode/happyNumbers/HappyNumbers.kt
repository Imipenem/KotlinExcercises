package leetcode.happyNumbers


fun isHappy(n: Int): Boolean {

    var res = 0
    var num = n
    val map = hashMapOf<Int,Int>()

    while(num != 1){

        while(num != 0){
            res += (num%10)*(num%10)
            num /= 10
        }
        if(map.containsKey(res)) return false
        map[res] = 1
        num = res
        res = 0
    }
    return true
}


fun main(){
    println(isHappy(19))
}