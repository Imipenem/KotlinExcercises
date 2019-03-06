package doublelinkedlist

import org.junit.jupiter.api.Assertions.*

internal class DoubleLinkedListTest {

    @org.junit.jupiter.api.Test
    fun insertAtEmptyListWithIndexOutOfBonds() {
        val node1 = Node(null,null,1)
        val node2 = Node(null,null,2)
        val node3 = Node(null,null,3)
        val node4 = Node(null,null,4)
        val node5 = Node(null,null,5)
        val node6 = Node(null,null,6)

        val testList = DoubleLinkedList<Int>(null,null)
        testList.insertAt(node1,100)
        val correctList = mutableListOf(1)
        val testListValues = mutableListOf<Int?>()
        testListValues.add(testList.head?.value)
        assertEquals(correctList,testListValues)
        assertEquals(testList.size(),1)
    }
    @org.junit.jupiter.api.Test
    fun insertAtVariousIndex() {
        val node1 = Node(null,null,1)
        val node2 = Node(null,null,2)
        val node3 = Node(null,null,3)
        val node4 = Node(null,null,4)
        val node5 = Node(null,null,5)
        val node6 = Node(null,null,6)

        val testList = DoubleLinkedList<Int>(null,null)
        testList.insertAt(node1,0)
        testList.insertAt(node2,100)
        testList.insertAt(node3,1)
        testList.insertAt(node4,2)
        testList.insertAt(node5,3)
        testList.insertAt(node6,2)
        val testListValues = testList.traverseListForValues()
        val correctList = mutableListOf(1,3,6,4,5,2)
        assertEquals(correctList,testListValues)
        assertEquals(testList.size(),6)
    }
    @org.junit.jupiter.api.Test
    fun insertAtVariousIndex2() {
        val node1 = Node(null,null,1)
        val node2 = Node(null,null,2)
        val node3 = Node(null,null,3)
        val node4 = Node(null,null,4)
        val node5 = Node(null,null,5)
        val node6 = Node(null,null,6)

        val testList = DoubleLinkedList<Int>(null,null)
        testList.insertAt(node1,3)
        testList.insertAt(node2,1)
        testList.insertAt(node3,3)
        testList.insertAt(node4,4)
        testList.insertAt(node5,1)
        testList.insertAt(node6,2)
        val testListValues = testList.traverseListForValues()
        val correctList = mutableListOf(1,5,6,2,3,4)
        assertEquals(correctList,testListValues)
        assertEquals(testList.size(),6)

    }
    @org.junit.jupiter.api.Test
    fun removeAt() {
        val node1 = Node(null,null,1)
        val node2 = Node(null,null,2)
        val node3 = Node(null,null,3)
        val node4 = Node(null,null,4)
        val node5 = Node(null,null,5)
        val node6 = Node(null,null,6)

        val testList = DoubleLinkedList<Int>(null,null)
        testList.insertAt(node1,3)
        testList.insertAt(node2,1)
        testList.insertAt(node3,3)
        testList.insertAt(node4,4)
        testList.insertAt(node5,1)
        testList.insertAt(node6,2)
        testList.removeAt(0)
        testList.removeAt(4)
        testList.removeAt(2)
        val testListValues = testList.traverseListForValues()
        val correctList = mutableListOf(5,6,3)
        assertEquals(correctList,testListValues)
        assertEquals(testList.size(),3)
    }
    @org.junit.jupiter.api.Test
    fun removeAndInsertMultipleTimes() {
        val node1 = Node(null,null,1)
        val node2 = Node(null,null,2)
        val node3 = Node(null,null,3)
        val node4 = Node(null,null,4)
        val node5 = Node(null,null,5)
        val node6 = Node(null,null,6)

        val testList = DoubleLinkedList<Int>(null,null)
        testList.insertAt(node1,3)
        testList.removeAt(17)
        testList.insertAt(node2,1)
        testList.insertAt(node3,3)
        testList.insertAt(node4,4)
        testList.removeAt(2)
        testList.insertAt(node5,1)
        testList.insertAt(node6,2)
        testList.removeAt(0)
        testList.removeAt(4)
        testList.insertAt(node1,1)
        testList.removeAt(2)
        val testListValues = testList.traverseListForValues()
        val correctList = mutableListOf(5,1)
        assertEquals(correctList,testListValues)
        assertEquals(testList.size(),2)
    }
}