package leetcode.oneortwobit


fun isOneBitCharacter(bits: IntArray): Boolean {
    var l = 0
    var r = 1

    while(r < bits.size){
        if (bits[l] == 0){
            l++
            r++
        }
        else{
            l +=2
            r +=2
        }
    }
    return  l == bits.size - 1
}


fun main(){
    println(isOneBitCharacter(intArrayOf(1,0,0)))
    println(isOneBitCharacter(intArrayOf(1,1,1,0)))
}