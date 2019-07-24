package leetcode.removelinkedlistelements

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    var headi = head
    var actual:ListNode?
    var before:ListNode?

    while(headi != null && headi.`val` == `val`){
        headi = headi.next
    }
    actual = headi?.next
    before = headi

    while(actual != null) {
        while( actual != null && actual.`val` == `val`){
            actual = actual.next
        }
        before?.next = actual
        before = actual
        actual = actual?.next
    }
    return headi
}

fun main(){
    val n1 = ListNode(1)
    val n2 = ListNode(1)
    val n3 = ListNode(1)
    val n4 = ListNode(1)
    val n5 = ListNode(1)
    val n6 = ListNode(1)
    val n7 = ListNode(1)

    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    n5.next = n6
    n6.next = n7

    val head = removeElements(n1,1)
    var curr = head

    while(curr != null) {
        println("This is node ${curr.`val`}")
        curr = curr.next
    }
}