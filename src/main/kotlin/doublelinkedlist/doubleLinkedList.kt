package doublelinkedlist

class DoubleLinkedList<T>(var head: Node<T>?) {
    private val node = Node(null, null, 2)
    private val precursorNode = Node(null, null, 1)
    private val followerNode = Node(null, null, 3)


    /**
     * Insert the node at the head of the linkedList (if there´s already a head node, the node will get it´s follower
     */
    fun insertFirst(node: Node<T>?) {
        if (head == null) head = node else head?.follower = node
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
}


fun main() {
    val list = DoubleLinkedList<Int>(null)
    val node = Node(null, null, 2)
    list.head = node
    println(list.size())
    print(list.head)
}
