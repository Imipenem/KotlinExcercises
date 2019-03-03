package doublelinkedlist

import java.lang.IllegalStateException

class DoubleLinkedList<T>(var head: Node<T>?, var tail: Node<T>?) {

    /**
     * Insert the node at the head of the linkedList (if there´s already a head node, the node will get it´s follower
     */
    fun insertFirst(node: Node<T>?) {
        when {
            size() > 1 -> throw IllegalStateException("Cannot invoke insertFirst() on lists with size greater than 1")
            head == null -> {
                head = node
                tail = head
            }
            else -> {
                tail = head
                tail?.precursor = node
                node?.follower = tail
                head = node
            }
        }
    }

    /**
     * This function returns the size of the list
     */
    fun size(): Int {
        var currentNode = head
        var size = 0
        while (currentNode != null) {
            size++
            currentNode = currentNode.follower
        }
        return size
    }

    /**
     * This function inserts a node at the end of the list
     */
    fun insertLast(node:Node<T>?) {
        tail?.follower = node
        node?.precursor = tail
        tail = node
    }
}

/**
 * Little test main()
 */
fun main() {
    val list = DoubleLinkedList<Int>(null,null)
    val node = Node(null, null, 1)
    val node2 = Node(null, null, 2)
    val node3 = Node(null, null, 3)
    val node4 = Node(null, null, 4)
    val node5 = Node(null, null, 5)
    list.insertFirst(node)
    list.insertFirst(node5)
    var testNode:Node<Int>? = list.head
    list.insertLast(node2)
    list.insertLast(node3)
    list.insertLast(node4)
    println(list.size())
    while(testNode!=null){
        println(testNode)
        testNode = testNode.follower
    }
}
