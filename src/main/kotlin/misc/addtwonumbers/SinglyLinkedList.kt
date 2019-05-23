package misc.addtwonumbers

class SinglyLinkedList {

    var head:ListNode? = null
    var tail:ListNode? = null

    fun insertLast(node: ListNode){
        when {
            head == null -> head = node
            tail == null -> {
                tail = node
                head?.next = node
            }
            else -> {
                tail?.next = node
                tail = node
            }
        }
    }
}