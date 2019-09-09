package leetcode.cousinsinbinarytree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
    return findLevel(root, x, 1) == findLevel(root, y, 1) && (
            !isSibling(root, x, y)
            )
}

fun findLevel(node: TreeNode?, value: Int, level: Int): Int {
    return if (node == null) 0
    else if (node.`val` == value) level
    else {
        val l = findLevel(node.left, value, level + 1)
        if (l != 0) l
        else findLevel(node.right, value, level + 1)
    }
}

fun isSibling(parent: TreeNode?, x: Int, y: Int): Boolean {
    return if (parent == null) false
    else {
        (parent.right?.`val` == x && parent.left?.`val` == y) || (
                parent.right?.`val` == y && parent.left?.`val` == x) || (
                isSibling(parent.left, x, y)) || (isSibling(parent.right, x, y))
    }
}


fun main() {
    val root = TreeNode(1)
    val n1 = TreeNode(2)
    val n2 = TreeNode(3)
    val n3 = TreeNode(4)
    val n4 = TreeNode(5)
    val n5 = TreeNode(15)
    val n6 = TreeNode(6)
    val n7 = TreeNode(7)
    val n8 = TreeNode(8)

    root.left = n1
    root.right = n2

    n1.left = n3
    n2.left = n5

    if (isCousins(root, 4, 15))
        println("Yes")
    else
        println("No")
}