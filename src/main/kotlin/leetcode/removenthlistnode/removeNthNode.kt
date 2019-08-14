package leetcode.removenthlistnode

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

    var current = head
    var previous: ListNode? = null
    var size = 0
    var ind = 1

    if (head?.next == null) return null

    while (current != null) {
        current = current.next
        size++
    }

    if (n == size) return head.next
    else {
        current = head
        while (ind < size + 1 - n) {
            previous = current
            current = current?.next
            ind++
        }
    }
    previous?.next = current?.next

    return head
}


fun main() {
    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(3)
    val n4 = ListNode(4)
    val n5 = ListNode(5)

    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5

    var current = removeNthFromEnd(n1, 2)

    while (current != null) {
        println(current.`val`)
        current = current.next
    }
}