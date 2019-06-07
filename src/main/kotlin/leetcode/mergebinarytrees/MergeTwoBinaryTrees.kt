package leetcode.mergebinarytrees

class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
         var right: TreeNode? = null
}

fun mergeTwoBinaryTrees(t1: TreeNode?, t2: TreeNode?):TreeNode?{
    if(t1 == null) return t2
    else if(t2 == null) return t1

    val newNode = TreeNode(t1.`val` + t2.`val`)
    newNode.left = mergeTwoBinaryTrees(t1.left,t2.left)
    newNode.right = mergeTwoBinaryTrees(t1.right,t2.right)

    return newNode
}

fun main(){
    val n11 = TreeNode(1)
    val n21 = TreeNode(3)
    val n31 = TreeNode(2)
    val n41 = TreeNode(5)

    n11.left = n21
    n11.right = n31
    n21.left = n41
    //--------------TREE 2---------------
    val n12 = TreeNode(2)
    val n22 = TreeNode(1)
    val n32 = TreeNode(3)
    val n42 = TreeNode(4)
    val n52 = TreeNode(7)


    n12.left = n22
    n12.right = n32
    n22.right = n42
    n32.right = n52

    val new = mergeTwoBinaryTrees(n11,n12)

    print(new?.`val`)
    print(new?.right?.`val`)
    print(new?.left?.`val`)
}