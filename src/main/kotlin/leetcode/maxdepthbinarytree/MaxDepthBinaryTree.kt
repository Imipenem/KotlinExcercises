package leetcode.maxdepthbinarytree

import kotlin.math.max


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun maxDepthBinaryTree(root:TreeNode?):Int{
    if (root == null) return 0 //we´ve reached a leaf; we´re finished and return 0
    return(1 + max(maxDepthBinaryTree(root.left), maxDepthBinaryTree(root.right))) // +1 for the next level for each subtree (calc max subtree depth left vs right)
}


fun main(){
    val n1 = TreeNode(1)
    val n2 = TreeNode(2)
    val n3 = TreeNode(3)
    val n4 = TreeNode(4)
    val n5 = TreeNode(5)

    n1.left = n2
    n1.right = n3
    n3.left = n4
    n4.left = n5

    println(maxDepthBinaryTree(n1))

}