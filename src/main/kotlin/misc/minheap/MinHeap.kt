package misc.minheap

import java.lang.IllegalStateException

/**
 * Min Heap Implementation (Complete Binary Tree) as an Implementation of the ADT PriorityQueue
 *
 * Credits: https://www.youtube.com/watch?v=g9YK6sftDi0
 */

class MinHeap {
    private var size = 0
    private var capacity = 10
    private var heap = IntArray(capacity)

    public fun isEmpty() = size == 0

    public fun peek() = if (isEmpty()) IllegalStateException() else heap[0]

    public fun remove(): Any {
        if (isEmpty()) return IllegalStateException()

        val min = heap[0]
        heap[0] = heap[size - 1]
        size--

        heapifyDown()
        return min
    }

    public fun add(item: Int) {
        ensureCapacity()

        heap[size] = item
        size++

        heapifyUp()

    }

    /**
     * Repeat until theres no leftChild (and thus 100% NO RIGHT CHILD (because we´re in a complete binary tree)) or both childs are
     * greater than me:
     * Take the lesser of the two childs (left as default) and swap them into the pos of me (I was the rightmost ("last") node that has been
     * taken as the "new root" after removing top element
     */
    private fun heapifyDown() {
        var ind = 0

        while (hasLeftChild(ind)) {

            var smallerChildInd = getLeftChildrenIndex(ind)

            if (hasRightChild(ind) && heap[getRightChildrenIndex(ind)] < heap[smallerChildInd]) {
                smallerChildInd = getRightChildrenIndex(ind)
            }

            if (heap[ind] < heap[smallerChildInd]) break
            else swap(ind, smallerChildInd)

            ind = smallerChildInd
        }
    }

    /**
     * Repeat (until I (the added value/child) has no parent or is greater than its parent: AM I (the added child node)
     * GREATER OR LESSER THAN MY PARENTS NODE VALUE?
     *
     * --> heapify me up until I am in the right position in the heap
     */
    private fun heapifyUp() {

        var ind = size - 1
        while (hasParent(ind) && parent(ind) > heap[ind]) {
            swap(getParentIndex(ind), ind)

            ind = getParentIndex(ind)
        }
    }


    private fun getLeftChildrenIndex(parentsInd: Int) = 2 * parentsInd + 1

    private fun getRightChildrenIndex(parentsInd: Int) = 2 * parentsInd + 2

    private fun getParentIndex(childrenInd: Int) = (childrenInd - 1) / 2

    private fun hasLeftChild(index: Int) = getLeftChildrenIndex(index) < size

    private fun hasRightChild(index: Int) = getRightChildrenIndex(index) < size

    private fun hasParent(index: Int) = getParentIndex(index) >= 0

    private fun leftChild(index: Int) = heap[getLeftChildrenIndex(index)]

    private fun rightChild(index: Int) = heap[getRightChildrenIndex(index)]

    private fun parent(index: Int) = heap[getParentIndex(index)]


    private fun ensureCapacity() {
        if (size == capacity) {
            heap = heap.copyOf(heap.size * 2)
            capacity *= 2
        }
    }

    private fun swap(firstInd: Int, secInd: Int) {
        val temp = heap[firstInd]
        heap[firstInd] = heap[secInd]
        heap[secInd] = temp
    }
}

fun main() {
    val minHeap = MinHeap()
    minHeap.add(17)
    minHeap.add(12)
    minHeap.add(15)
    minHeap.add(10)
    minHeap.add(5)

    println(minHeap.peek())
    minHeap.remove()
    println(minHeap.peek())
}