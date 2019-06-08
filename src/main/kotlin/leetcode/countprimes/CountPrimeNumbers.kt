package leetcode.countprimes

fun countPrimes(n: Int): Int {
    var count = 0
    var p = 2
    val sieve = BooleanArray(n)

    for(i in 2 until sieve.size){
        sieve[i] = true
    }

    while(p*p < n){
        if(sieve[p]){
            for (j in p*p until sieve.size step p ){
                sieve[j] = false
            }
        }
        p++
    }

    for (e in 0 until sieve.size){
        if(sieve[e]) count++
    }
    return count
}


fun main(){
    println(countPrimes(10))
    println(countPrimes(1))
    println(countPrimes(2))
    println(countPrimes(1000000))
}