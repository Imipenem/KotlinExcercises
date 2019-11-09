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

    /**
     * Repeat until theres no leftChild (and thus 100% NO RIGHT CHILD (because we´re in a complete binary tree)) or both childs are
     * greater than me:
     * Take the lesser of the two childs (left as default) and swap them into the pos of me (I was the rightmost ("last") node that has been
     * taken as the "new root" after removing top element
     */
    private fun heapifyDownBuild(index: Int, array: IntArray) {
        var ind = index

        while (hasLeftChildt(ind, array)) {

            var smallerChildInd = getLeftChildrenIndex(ind)

            if (hasRightChildt(ind, array) && array[getRightChildrenIndex(ind)] < array[smallerChildInd]) {
                smallerChildInd = getRightChildrenIndex(ind)
            }

            if (array[ind] < array[smallerChildInd]) break
            else swaphere(ind, smallerChildInd, array)

            ind = smallerChildInd
        }
    }

    private fun heapifyDownSort(array: IntArray, lim: Int) {
        var ind = 0

        while (ind < lim && hasLeftChildtt(ind, array, lim + 1)) {

            var smallerChildInd = getLeftChildrenIndex(ind)

            if (hasRightChildtt(ind, array, lim) && array[getRightChildrenIndex(ind)] < array[smallerChildInd]) {
                smallerChildInd = getRightChildrenIndex(ind)
            }

            if (array[ind] < array[smallerChildInd]) break
            else swaphere(ind, smallerChildInd, array)

            ind = smallerChildInd
        }
    }

    private fun swaphere(firstInd: Int, secInd: Int, array: IntArray) {
        val temp = array[firstInd]
        array[firstInd] = array[secInd]
        array[secInd] = temp
    }

    private fun hasLeftChildt(index: Int, array: IntArray) = getLeftChildrenIndex(index) < array.size

    private fun hasLeftChildtt(index: Int, array: IntArray, lim: Int) = getLeftChildrenIndex(index) < lim

    private fun hasRightChildt(index: Int, array: IntArray) = getRightChildrenIndex(index) < array.size
    private fun hasRightChildtt(index: Int, array: IntArray, lim: Int) = getRightChildrenIndex(index) <= lim


    private fun hasParentt(index: Int, array: IntArray) = getParentIndex(index) >= 0

    private fun leftChildt(index: Int, array: IntArray) = array[getLeftChildrenIndex(index)]

    private fun rightChildt(index: Int, array: IntArray) = array[getRightChildrenIndex(index)]

    private fun parentt(index: Int, array: IntArray) = array[getParentIndex(index)]

    fun buildHeap(array: IntArray) {
        for (i in array.size / 2 downTo 0) {
            heapifyDownBuild(i, array)
        }
    }

    fun heapSort(array: IntArray) {
        for (i in array.size - 1 downTo 1) {
            swaphere(0, i, array)
            heapifyDownSort(array, i - 1)
        }
    }
}

fun main() {
    val minHeap = MinHeap()
    val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    minHeap.buildHeap(array)
    minHeap.heapSort(array)
    for (e in array) {
        println(e)
    }

    //minHeap.add(17)
    //minHeap.add(12)
    //minHeap.add(15)
    //minHeap.add(10)
    //minHeap.add(5)

    //println(minHeap.peek())
    //minHeap.remove()
    //println(minHeap.peek())
}