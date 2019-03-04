package doublelinkedlist

class DoubleLinkedList<T>(var head: Node<T>?, var tail: Node<T>?) {

    /**
     * Insert the node at the head of the linkedList (if there´s already a head node, the node will get it´s follower)
     */
    fun insertFirst(node: Node<T>?) {
        when {
            head == null -> {
                head = node
                tail = head
            }
            size() == 1 -> {
                tail = head
                tail?.precursor = node
                node?.follower = tail
                head = node
            }
            else -> {
                head?.precursor = node
                node?.follower = head
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
     fun insertLast(node: Node<T>?) {
        if(size() == 0) head = node
        tail?.follower = node
        node?.precursor = tail
        tail = node
    }

    /**
     * This function inserts a node at a given position (or at the end of index is outOfBonds)
     */
    fun insertAt(node: Node<T>?, index: Int) {
        when {
            index == 0 -> insertFirst(node)
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
    /**
     * This function removes removes the node form the list at the given index
     */
    fun removeFirst(){
        if (size() == 1) tail = null
        head = head?.follower
        head?.precursor?.follower = null
        head?.precursor = null
    }
    /**
     * This function removes removes the node form the list at the given index
     */
    fun removeLast(){
        if (size() == 1) head = null
        tail = tail?.precursor
        tail?.follower?.precursor = null
        tail?.follower = null
    }
    /**
     * This function removes removes the node form the list at the given index
     */
    fun removeAt(index:Int){
        when {
                index == 0 -> removeFirst()
                index > size()-1 -> removeLast()
                else -> {
                    var currentNode = head?.follower
                    var currentIndex = 1
                    while (currentIndex != index) {
                        currentNode = currentNode?.follower
                        currentIndex++
                    }
                    currentNode?.follower?.precursor = currentNode?.precursor
                    currentNode?.precursor?.follower = currentNode?.follower
                    currentNode?.follower = null
                    currentNode?.precursor = null
                }
        }
    }

    /**
     * Little helper function for searching a node at a specific index, beginning at index 1
     */
    fun traverseList(index:Int){
        var currentNode = head?.follower
        var currentIndex = 1
        while (currentIndex != index) {
            currentNode = currentNode?.follower
            currentIndex++
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
    list.removeAt(1)
    //list.insertAt(node3,12)
    //list.insertAt(node2,1)
    //println("Tail is: ${list.tail}")
    var testNode: Node<Int>? = list.head
    while (testNode != null) {
        println(testNode)
        testNode = testNode.follower
    }
}
