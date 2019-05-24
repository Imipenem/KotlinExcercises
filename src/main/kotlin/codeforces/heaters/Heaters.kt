package codeforces.heaters

fun countHeaters(n:Int,v:Int,array:List<String>):Int{
     var lastHeater = -1
     var heaters = 0
     var rightmost = v-1
    if(rightmost > n-1){
        rightmost = n-1
    }

    while(array[rightmost]!="1"){
        rightmost--
        if(rightmost==lastHeater){
            return -1
        }
    }
    lastHeater = rightmost
    heaters++

    while(lastHeater+(v-1) < n-1){
        rightmost+=(2*v-1)
        if(rightmost > n-1){
            rightmost = n-1
        }

        while(array[rightmost]!="1"){
            rightmost--
            if(rightmost==lastHeater){
                return -1
            }
        }
        lastHeater = rightmost
        heaters++
    }
    return heaters
}

fun main(args:Array<String>){
    val s = readLine()!!.split(" ")
    val t = readLine()!!.split(" ")
    println(countHeaters(s[0].toInt(),s[1].toInt(), t))

}