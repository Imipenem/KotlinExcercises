package doublelinkedlist

class DoubleLinkedList<T>(var head: Node<T>?, var tail: Node<T>?) {

    /**
     * Insert the node at the head of the linkedList (if there´s already a head node, the node will get it´s follower
     */
    fun insertFirst(node: Node<T>?) {
        when (head) {
            null -> {
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
    private fun size(): Int {
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
    private fun insertLast(node: Node<T>?) {
        tail?.follower = node
        node?.precursor = tail
        tail = node
    }

    /**
     * This function inserts a node at a given position (or at the end of index is outOfBonds)
     */
    fun insertAt(node: Node<T>?, index: Int) {
        when {
            index == 0 -> insertFirst(node) //doesn't work on lists size > 1!!!!
            index > size() - 1 -> insertLast(node)
            else -> {
                var currentNode = head
                var currentIndex = 0
                while (currentIndex != index) {
                    currentNode = currentNode?.follower
                    currentIndex++
                }
                node?.follower = currentNode
                node?.precursor = currentNode?.precursor
                node?.follower?.precursor = node
                node?.precursor?.follower = node
            }
        }
    }
}

/**
 * Little test main()
 */
fun main() {
    val list = DoubleLinkedList<Int>(null, null)
    val node = Node(null, null, 1)
    val node2 = Node(null, null, 2)
    val node3 = Node(null, null, 3)
    val node4 = Node(null, null, 4)
    val node5 = Node(null, null, 5)
    list.insertFirst(node)
    list.insertAt(node3, 5)
    list.insertAt(node2, 1)
    list.insertAt(node4, 2)
    list.insertAt(node5, 0)
    var testNode: Node<Int>? = list.head
    while (testNode != null) {
        println(testNode)
        testNode = testNode.follower
    }
}
