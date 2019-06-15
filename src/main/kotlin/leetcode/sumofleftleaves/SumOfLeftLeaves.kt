package leetcode.sumofleftleaves

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun sumOfLeftLeaves(root: TreeNode?): Int {
    var sum = 0

    if(root != null){
        sum += if(isLeaf(root.left)) root.left!!.`val`
        else sumOfLeftLeaves(root.left)
        sum += sumOfLeftLeaves(root.right)
    }
    return sum
}

fun isLeaf(node: TreeNode?):Boolean{
    return if (node == null) false
    else node.left == null && node.right == null
}


fun main(){
    val n11 = TreeNode(3)
    val n21 = TreeNode(9)
    val n31 = TreeNode(20)
    val n41 = TreeNode(15)
    val n51 = TreeNode(7)

    n11.left = n21
    n11.right = n31
    n31.left = n41
    n31.right = n51

    println(sumOfLeftLeaves(n11))
}