package leetcode.maxspace
import kotlin.math.max


fun maxspace(seats:IntArray):Int{
    var l = -1
    var r = 0
    var max = 0

    while(true){
        while(r < seats.size && seats[r] == 0) {
            r++
        }

        max = if(l == -1) r
        else if (r == seats.size && seats[r - 1] == 0) return max(max, r - l - 1)
        else max(max, (r - l)/2)

        while(r < seats.size && seats[r] == 1){
            r++
            if(r == seats.size) return max
        }
        l = r - 1
    }
}


fun main(){
    println(maxspace(intArrayOf(0,0,0,0,0,1)))
}