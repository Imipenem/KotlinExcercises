package leetcode.getsum

fun getSum(a:Int, b:Int):Int{

    var carry:Int
    var a = a
    var b = b
    while(b != 0){
        carry = a.and(b) // save all carries we will need
        a = a.xor(b) // add b to a (ignoring the carries first then add the carries from round before)
        b = carry.shl(1) // "bring carries in right position for adding"
    }
    return a
}

fun main(){
    println(getSum(1,-2))
}