package leetcode.maxdepth_n_ary_tree
import kotlin.math.max

class TreeNode(var `val`: Int, var _children:MutableList<TreeNode>) {
    val children = _children
}

fun maxDepthNaryTree(root:TreeNode?):Int {
    var max = 0

    return if(root == null) 0
    else {
        for(node in root.children){
            max = max(max, maxDepthNaryTree(node))
        }
        max + 1
    }
}

fun main(){
    var n2 = TreeNode(2, mutableListOf())
    var n3= TreeNode(3, mutableListOf())
    var n4= TreeNode(4, mutableListOf())
    var n5= TreeNode(5, mutableListOf())
    var n6= TreeNode(6, mutableListOf())
    var n7= TreeNode(7, mutableListOf())
    var n8= TreeNode(8, mutableListOf())
    var n9 = TreeNode(9, mutableListOf())
    var n1 = TreeNode(1, mutableListOf())

    n1.children.addAll(mutableListOf(n2,n3,n4,n5))
    n2.children.addAll(mutableListOf(n6,n7))
    n4.children.addAll(mutableListOf(n8))
    n8.children.add(n9)

    println(maxDepthNaryTree(n1))
}