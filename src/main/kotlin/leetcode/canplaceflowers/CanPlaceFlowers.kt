package leetcode.canplaceflowers


fun canPlace(flowerbed: IntArray, n: Int):Boolean{

    var actualCount = 0

    for(i in 0 until flowerbed.size){
        if(flowerbed[i] == 1) continue

        if(i == 0){
            if (flowerbed.size == 1 || flowerbed[i + 1] == 0){
                flowerbed[i] = 1
                actualCount++
            }
        }

        else if(i == flowerbed.size - 1){
            if(flowerbed[i-1] == 0) {
                flowerbed[i] = 1
                actualCount++
            }
        }

        else if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
            flowerbed[i] = 1
            actualCount++
        }
    }

    return actualCount >= n
}


fun main(){
    println(canPlace(intArrayOf(1),1))
    println(canPlace(intArrayOf(1,0,0,0,1),2))
}