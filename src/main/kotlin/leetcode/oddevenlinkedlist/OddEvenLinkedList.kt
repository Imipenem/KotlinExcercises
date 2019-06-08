package leetcode.oddevenlinkedlist

class ListNode(var `val`: Int) {
    var next: ListNode? = null
     }

fun oddEvenList(head: ListNode?): ListNode? {

    if(head?.next == null || head.next?.next == null) return head
    var actualOdd = head.next?.next
    val firstEven = head.next
    var leftOdd = head
    var actualEven = firstEven
    var nextEven = actualOdd?.next

    while(actualOdd?.next != null && actualOdd.next?.next != null){

        actualEven?.next = nextEven
        leftOdd?.next = actualOdd
        actualOdd.next = firstEven

        leftOdd = actualOdd
        actualOdd = nextEven?.next

        actualEven = actualEven?.next
        nextEven = actualOdd?.next
    }

    if(actualEven?.next?.next == null){ // list with odd length
        leftOdd?.next = actualOdd
        actualOdd?.next = firstEven
        actualEven?.next = null
    }

    else if(nextEven?.next == null){ // list with even length
        leftOdd?.next = actualOdd
        actualOdd?.next = firstEven
        actualEven.next = nextEven
    }

    return head
}


fun main(){
    val node1 = ListNode(1)
    val node2 = ListNode(1)
    val node3 = ListNode(3)
    val node4 = ListNode(5)
    val node5 = ListNode(6)
    val node6 = ListNode(4)
    val node7 = ListNode(7)
    val node8 = ListNode(8)
    val node9 = ListNode(9)
    val node10 = ListNode(10)
    val node11 = ListNode(11)

    node1.next = node2


    var result = oddEvenList(node1)

    while(result != null){
        println("This is Node ${result.`val`}")
        result = result.next
    }
}