package misc.addtwonumbers

class AddTwoNumbers {
    fun addTwoNumbers(list1:SinglyLinkedList, list2:SinglyLinkedList):SinglyLinkedList {
        var currentNodeList1 = list1.head
        var currentNodeList2 = list2.head
        var temp = 0
        val resultList = SinglyLinkedList()
        while(currentNodeList1!=null || currentNodeList2!=null){
            if (currentNodeList1!=null){
                temp+=currentNodeList1.value
                currentNodeList1=currentNodeList1.next
            }

            if (currentNodeList2!=null){
                temp+=currentNodeList2.value
                currentNodeList2=currentNodeList2.next
            }
            resultList.insertLast(ListNode(temp%10,null))
            temp/=10
        }
        if(temp !=0){
            while (temp!=0){
                resultList.insertLast(ListNode(temp%10,null))
                temp/=10
            }
        }
        return resultList
    }
}


fun main(){
    val node7=ListNode(1,null)
    val node3=ListNode(0,null)
    val node2=ListNode(0,null)
    val node1=ListNode(0,null)

    val node6=ListNode(9,null)
    val node5=ListNode(9,null)
    val node4=ListNode(9,null)

    val list1 = SinglyLinkedList()
    val list2 = SinglyLinkedList()
    list1.insertLast(node1)
    list1.insertLast(node2)
    list1.insertLast(node3)
    list1.insertLast(node7)

    list2.insertLast(node4)
    list2.insertLast(node5)
    list2.insertLast(node6)

    val AddTwoNumberss = AddTwoNumbers()

    val list = AddTwoNumberss.addTwoNumbers(list1,list2)
    val currentNode = list.head

    println(currentNode?.value)
    println(currentNode?.next?.value)
    println(currentNode?.next?.next?.value)
    println(currentNode?.next?.next?.next?.value)
}