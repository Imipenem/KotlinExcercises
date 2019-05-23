package doublelinkedlist

class DoubleLinkedList<T>(var head: Node<T>?, var tail: Node<T>?) : Iterable<Node<T>> {


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
        if (size() == 0) head = node

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
    fun removeFirst() {
        if (size() == 1) tail = null
        head = head?.follower
        head?.precursor?.follower = null
        head?.precursor = null
    }

    /**
     * This function removes removes the node form the list at the given index
     */
    fun removeLast() {
        if (size() == 1) head = null
        tail = tail?.precursor
        tail?.follower?.precursor = null
        tail?.follower = null
    }

    /**
     * This function removes removes the node form the list at the given index
     */
    fun removeAt(index: Int) {
        when {
            index == 0 -> removeFirst()
            index >= size() - 1 -> removeLast()
            else -> {
                val node = traverseList(index)
                node?.follower?.precursor = node?.precursor
                node?.precursor?.follower = node?.follower
                node?.follower = null
                node?.precursor = null
            }
        }
    }

    /**
     * Get the node at the given index
     */

    fun getAt(index: Int): Node<T>? {
        var currentIndex = 0
        var currentNode = head
        if (index > size()) return tail

        while (currentIndex != index) {
            currentNode = currentNode?.follower
            currentIndex++
        }
        return currentNode
    }

    /**
     * Set the node´s value at the given index
     */

    fun setAt(index: Int, value: T) {
        var currentIndex = 0
        var currentNode = head
        if (index > size()) tail?.value = value

        while (currentIndex != index) {
            currentNode = currentNode?.follower
            currentIndex++
        }
        currentNode?.value = value
    }

    /**
     * Little helper function for searching a node at a specific index, beginning at index 1
     */
    fun traverseList(index: Int): Node<T>? {
        var currentNode = head?.follower
        var currentIndex = 1
        while (currentIndex != index) {
            currentNode = currentNode?.follower
            currentIndex++
        }
        return currentNode
    }

    /**
     * Little helper function for getting all values of the nodes in the list
     */
    fun traverseListForValues(): List<T> {
        val list = mutableListOf<T>()
        var currentNode = head
        while (currentNode != null) {
            list.add(currentNode.value)
            currentNode = currentNode.follower
        }
        return list
    }

    override fun iterator() = object : Iterator<Node<T>> {
        var node = head
        override fun hasNext() = node != null

        override fun next(): Node<T> {
            val currentNode = node
            node = node?.follower
            return currentNode!!
        }
    }

    operator fun plus(list: DoubleLinkedList<T>): DoubleLinkedList<T> {
        val result = DoubleLinkedList<T>(null, null)

        forEach { result.insertLast(it) }
        list.forEach { result.insertLast(it) }
        return result
    }
}

/**
 * Little test misc.adddigits.main()
 */
fun main() {
    println(10*0.1)
    println(0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1)
}

